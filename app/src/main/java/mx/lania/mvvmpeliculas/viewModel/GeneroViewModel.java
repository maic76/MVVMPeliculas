package mx.lania.mvvmpeliculas.viewModel;

import androidx.lifecycle.ViewModel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import mx.lania.mvvmpeliculas.repository.GeneroRepository;
import mx.lania.mvvmpeliculas.roomDB.Entities.TableGenero;


public class GeneroViewModel extends ViewModel {
    GeneroRepository generoRepository;

    public GeneroViewModel(GeneroRepository generoRepository){
        this.generoRepository = generoRepository;
    }

    public void insertarNuevoGenero(TableGenero nuevoGenero) {
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(() -> generoRepository.insertarGenero(nuevoGenero));
    }
}
