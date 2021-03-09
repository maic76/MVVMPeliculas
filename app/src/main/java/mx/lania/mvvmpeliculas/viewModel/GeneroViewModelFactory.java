package mx.lania.mvvmpeliculas.viewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

import mx.lania.mvvmpeliculas.repository.GeneroRepository;

@Singleton
public class GeneroViewModelFactory implements ViewModelProvider.Factory {

    @Inject
    GeneroRepository generoRepository;

    GeneroViewModel generoViewModel;

    public GeneroViewModelFactory(GeneroRepository generoRepository){
        this.generoRepository=generoRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (generoViewModel == null) {
            if (modelClass.isAssignableFrom(GeneroViewModel.class)) {
                generoViewModel = new GeneroViewModel(generoRepository);
            }
        }
        if (generoViewModel == null)
            throw new IllegalArgumentException("Unknown class name");
        return (T) generoViewModel;
    }
}
