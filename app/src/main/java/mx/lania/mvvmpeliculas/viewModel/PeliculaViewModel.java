package mx.lania.mvvmpeliculas.viewModel;

import androidx.lifecycle.ViewModel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import mx.lania.mvvmpeliculas.repository.PeliculaRepository;
import mx.lania.mvvmpeliculas.roomDB.Entities.TablePelicula;

public class PeliculaViewModel extends ViewModel {

    PeliculaRepository peliculaRepository;

    public PeliculaViewModel(PeliculaRepository peliculaRepository){
        this.peliculaRepository = peliculaRepository;
    }

    public void insertarNuevaPelicula(TablePelicula nuevaPelicula) {
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(() -> peliculaRepository.insertarPelicula(nuevaPelicula));
    }



}
