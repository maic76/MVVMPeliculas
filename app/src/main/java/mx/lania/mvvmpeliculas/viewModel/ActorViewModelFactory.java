package mx.lania.mvvmpeliculas.viewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

import mx.lania.mvvmpeliculas.repository.ActorRepository;

@Singleton
public class ActorViewModelFactory implements ViewModelProvider.Factory {
    @Inject
    ActorRepository actorRepository;

    ActorViewModel actorViewModel;

    public ActorViewModelFactory(ActorRepository actorRepository){
        this.actorRepository=actorRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (actorViewModel == null) {
            if (modelClass.isAssignableFrom(ActorViewModel.class)) {
                actorViewModel = new ActorViewModel(actorRepository);
            }
        }
        if (actorViewModel == null)
            throw new IllegalArgumentException("Unknown class name");
        return (T) actorViewModel;
    }
}
