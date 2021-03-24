package mx.lania.mvvmpeliculas.UI.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.lania.mvvmpeliculas.MVVMPeliculas;
import mx.lania.mvvmpeliculas.POJOS.PeliculaPOJO;
import mx.lania.mvvmpeliculas.R;
import mx.lania.mvvmpeliculas.UI.adapters.AdapterRecyclerView;
import mx.lania.mvvmpeliculas.roomDB.Entities.TablePelicula;
import mx.lania.mvvmpeliculas.services.ProgressIntentService;
import mx.lania.mvvmpeliculas.utils.CheckConnection;
import mx.lania.mvvmpeliculas.utils.Constants;
import mx.lania.mvvmpeliculas.viewModel.PeliculaViewModel;
import es.dmoral.toasty.Toasty;


public class FragmentPelicula extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    @Inject
    @Named("PeliculaFactory")
    ViewModelProvider.Factory viewModelFactoryPelicula;
    private PeliculaViewModel peliculaViewModel;

    @BindView(R.id.rvPeliculas)
    RecyclerView recyclerViewPelicula;
    @BindView(R.id.srPeliculas)
    SwipeRefreshLayout srPelicula;
    @BindView(R.id.pbPeliculas)
    ProgressBar pbPeliculas;

    AdapterRecyclerView adapterRecyclerView;

    public FragmentPelicula() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_pelicula, container, false);
        ButterKnife.bind(this,view);

        //Inicializar Dagger2
        ((MVVMPeliculas) getActivity().getApplication()).getAppComponent().inject(this);
        //Cargar ViewModel
        peliculaViewModel = ViewModelProviders.of(this, viewModelFactoryPelicula).get(PeliculaViewModel.class);

        cargarPeliculas();

        adapterRecyclerView.notifyDataSetChanged();

        srPelicula.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        srPelicula.setOnRefreshListener(this);

        return view;
    }

    public void cargarPeliculas(){
        recyclerViewPelicula.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewPelicula.setLayoutManager(layoutManager);

        if (CheckConnection.getInstance(getContext()).isOnline()) {
            adapterRecyclerView = new AdapterRecyclerView(dataSetRemoto(), getContext());
            recyclerViewPelicula.setAdapter(adapterRecyclerView);
            Toasty.success(getContext(), "TRABAJANDO REMOTO", Toast.LENGTH_LONG, true).show();
        } else {
            adapterRecyclerView = new AdapterRecyclerView(dataSetLocal(), getContext());
            recyclerViewPelicula.setAdapter(adapterRecyclerView);
            Toasty.warning(getContext(), "Sin conexión, se trabajará localmente", Toast.LENGTH_LONG, true).show();
        }
    }

    private ArrayList<PeliculaPOJO> dataSetRemoto() {
        ArrayList<PeliculaPOJO> data = new ArrayList<>();
        peliculaViewModel.getPeliculas().observe(this, apiPeliculasResponse -> {
            if (!apiPeliculasResponse.isEmpty()) {
                srPelicula.setRefreshing(false);
                srPelicula.setVisibility(View.VISIBLE);
                pbPeliculas.setVisibility(View.GONE);
                //Iniciamos el servicio
                Intent intent = new Intent(getActivity(), ProgressIntentService.class);
                intent.setAction(Constants.ACTION_RUN_ISERVICE);
                Bundle extras = new Bundle();
                extras.putInt("totalPeliculas",apiPeliculasResponse.size());
                intent.putExtras(extras);
                getActivity().startService(intent);

                for (int i = 0; i < apiPeliculasResponse.size(); i++) {
                    int idPelicula = apiPeliculasResponse.get(i).getId();
                    String tituloPelicula = apiPeliculasResponse.get(i).getTituloPelicula();
                    int anioEstreno = apiPeliculasResponse.get(i).getAnioEstreno();
                    String poster = apiPeliculasResponse.get(i).getPoster();

                    data.add(new PeliculaPOJO(idPelicula, tituloPelicula, anioEstreno, poster));
                    adapterRecyclerView.notifyDataSetChanged();

                    TablePelicula nuevaPelicula = new TablePelicula(idPelicula, tituloPelicula, anioEstreno, poster);
                    guardarPeliculaLocalmente(nuevaPelicula);
                }
            } else {
                srPelicula.setRefreshing(false);
                srPelicula.setVisibility(View.VISIBLE);
                pbPeliculas.setVisibility(View.GONE);
                Toasty.warning(getContext(), "No se encontraron peliculas.", Toast.LENGTH_LONG).show();
            }
        });
        return data;
    }

    public void guardarPeliculaLocalmente(TablePelicula nuevaPelicula) {
        int id = peliculaViewModel.getPeliculaById(nuevaPelicula.getIdPelicula());
        if (id == 0) {
            peliculaViewModel.insertarNuevaPelicula(nuevaPelicula);
        } else {
            peliculaViewModel.actualizarPelicula(nuevaPelicula);
        }
    }

    private ArrayList<PeliculaPOJO> dataSetLocal() {
        ArrayList<PeliculaPOJO> data = new ArrayList<>();
        peliculaViewModel.getPeliculasLocales().observe(this, peliculaLocal -> {
            if (!peliculaLocal.isEmpty()) {
                srPelicula.setRefreshing(false);
                srPelicula.setVisibility(View.VISIBLE);
                pbPeliculas.setVisibility(View.GONE);
                for (int i = 0; i < peliculaLocal.size(); i++) {
                    int idPelicula = peliculaLocal.get(i).getIdPelicula();
                    String tituloPelicula = peliculaLocal.get(i).getTituloPelicula();
                    int anioEstreno = peliculaLocal.get(i).getAnioEstreno();
                    String poster = peliculaLocal.get(i).getPoster();

                    data.add(new PeliculaPOJO(idPelicula, tituloPelicula, anioEstreno, poster));
                    adapterRecyclerView.notifyDataSetChanged();
                }
            } else {
                srPelicula.setRefreshing(false);
                srPelicula.setVisibility(View.VISIBLE);
                pbPeliculas.setVisibility(View.GONE);
                Toasty.warning(getContext(), "No se encontraron peliculas.", Toast.LENGTH_LONG).show();
            }
        });
        return data;
    }

    @Override
    public void onRefresh() {
        cargarPeliculas();
    }
}
