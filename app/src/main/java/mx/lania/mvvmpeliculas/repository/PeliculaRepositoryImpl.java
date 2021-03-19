package mx.lania.mvvmpeliculas.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mx.lania.mvvmpeliculas.remote.endpoints.Pelicula_REST;
import mx.lania.mvvmpeliculas.remote.models.PeliculaResponse;
import mx.lania.mvvmpeliculas.roomDB.DAOs.DAOPelicula;
import mx.lania.mvvmpeliculas.roomDB.Entities.TablePelicula;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculaRepositoryImpl implements PeliculaRepository {

    private DAOPelicula daoPelicula;

    @Inject
    public Pelicula_REST peliculaRest;

    @Inject
    PeliculaRepositoryImpl(DAOPelicula daoPelicula) {
        this.daoPelicula = daoPelicula;
    }

    // ---------------------- BD ROOM ---------------------------------------//
    @Override
    public void insertarPelicula(TablePelicula nuevaPelicula) {
         daoPelicula.insertarPelicula(nuevaPelicula);
    }

    @Override
    public int getPeliculaById(int idPelicula) {
        return daoPelicula.getPeliculaById(idPelicula);
    }

    @Override
    public void actualizarPelicula(TablePelicula actualizaPelicula) {
        daoPelicula.actualizarPelicula(actualizaPelicula);
    }

    @Override
    public LiveData<List<TablePelicula>> getPeliculasLocales() {
        final MutableLiveData<List<TablePelicula>> liveData = new MutableLiveData<>();
        liveData.setValue(daoPelicula.getPeliculasLocales());
        return liveData;
    }

    @Override
    public LiveData<List<TablePelicula>> getAll() {
        return daoPelicula.getAll();
    }

    //---------------------  REMOTO -------------------------------------//
    @Override
    public LiveData<List<PeliculaResponse>> getPeliculas() {
        final MutableLiveData<List<PeliculaResponse>> liveData = new MutableLiveData<>();
        peliculaRest.getPeliculas().enqueue(new Callback<List<PeliculaResponse>>() {
            @Override
            public void onResponse(Call<List<PeliculaResponse>> call, Response<List<PeliculaResponse>> response) {
                if(response.isSuccessful()){
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<PeliculaResponse>> call, Throwable t) {
                ArrayList<PeliculaResponse> listaDeUno = new ArrayList<>();

                PeliculaResponse peliculaFallida = new PeliculaResponse();
                peliculaFallida.setId(0);
                peliculaFallida.setTituloPelicula("NO HUBO RESPUESTA");
                peliculaFallida.setAnioEstreno(0);
                peliculaFallida.setPoster("NO HUBO RESPUESTA");
                listaDeUno.add(peliculaFallida);
                liveData.setValue(listaDeUno);

            }
        });
        return liveData;
    }

}
