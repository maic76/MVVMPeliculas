package mx.lania.mvvmpeliculas.viewModel;

import androidx.lifecycle.ViewModel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import mx.lania.mvvmpeliculas.repository.ActorRepository;
import mx.lania.mvvmpeliculas.roomDB.Entities.TableActor;

public class ActorViewModel extends ViewModel {
    ActorRepository actorRepository;

    public ActorViewModel(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }

    public void insertarNuevoActor(TableActor nuevoActor) {
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(() -> actorRepository.insertarActor(nuevoActor));
    }

}
