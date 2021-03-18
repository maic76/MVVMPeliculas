package mx.lania.mvvmpeliculas.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import mx.lania.mvvmpeliculas.remote.models.PeliculaResponse;
import mx.lania.mvvmpeliculas.repository.PeliculaRepository;
import mx.lania.mvvmpeliculas.roomDB.Entities.TablePelicula;

public class PeliculaViewModel extends ViewModel {

    private MediatorLiveData<List<PeliculaResponse>> peliculaResponseLiveData;

    PeliculaRepository peliculaRepository;

    public PeliculaViewModel(PeliculaRepository peliculaRepository){
        peliculaResponseLiveData = new MediatorLiveData<>();
        this.peliculaRepository = peliculaRepository;
    }

    @NonNull
    public LiveData<List<PeliculaResponse>> getApiPeliculaResponse(){
        return peliculaResponseLiveData;
    }

    /*----------------------------------- BD ROOM -----------------------------------*/
    public void insertarNuevaPelicula(TablePelicula nuevaPelicula) {
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(() -> peliculaRepository.insertarPelicula(nuevaPelicula));
    }

    public int getPeliculaById(int idPelicula){
        return peliculaRepository.getPeliculaById(idPelicula);
    }

    public void actualizarPelicula(TablePelicula actualizaPelicula){
        peliculaRepository.actualizarPelicula(actualizaPelicula);
    }

    public LiveData<List<TablePelicula>> getPeliculasLocales(){
        MediatorLiveData<List<TablePelicula>> getPeliculaLocal = new MediatorLiveData<>();
        getPeliculaLocal.addSource(peliculaRepository.getPeliculasLocales(),pelicula->getPeliculaLocal.setValue(pelicula));
        return getPeliculaLocal;
    }

    // --------------------- REMOTO ----------------------------------------//
    public LiveData<List<PeliculaResponse>> getPeliculas(){
        final MediatorLiveData<List<PeliculaResponse>> liveData = new MediatorLiveData<>();
            liveData.addSource(peliculaRepository.getPeliculas(),apiPeliculaResponse->liveData.setValue(apiPeliculaResponse));
            return liveData;
    }





}
