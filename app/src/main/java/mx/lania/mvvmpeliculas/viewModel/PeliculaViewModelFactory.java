package mx.lania.mvvmpeliculas.viewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

import mx.lania.mvvmpeliculas.repository.PeliculaRepository;

@Singleton
public class PeliculaViewModelFactory implements ViewModelProvider.Factory {

    @Inject
    PeliculaRepository peliculaRepository;

    PeliculaViewModel peliculaViewModel;

    public PeliculaViewModelFactory(PeliculaRepository peliculaRepository){
            this.peliculaRepository=peliculaRepository;
        }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (peliculaViewModel == null) {
            if (modelClass.isAssignableFrom(PeliculaViewModel.class)) {
                peliculaViewModel = new PeliculaViewModel(peliculaRepository);
            }
        }
        if (peliculaViewModel == null)
            throw new IllegalArgumentException("Unknown class name");
        return (T) peliculaViewModel;
    }
}
