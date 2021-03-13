package mx.lania.mvvmpeliculas.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import mx.lania.mvvmpeliculas.roomDB.DAOs.DAOActor;
import mx.lania.mvvmpeliculas.roomDB.Entities.TableActor;

public class ActorRepositoryImpl implements ActorRepository{
    private DAOActor daoActor;

    @Inject
    ActorRepositoryImpl(DAOActor daoActor) {
        this.daoActor = daoActor;
    }

    @Override
    public void insertarActor(TableActor nuevoActor) {
        daoActor.insertarActor(nuevoActor);
    }

    @Override
    public LiveData<List<TableActor>> getAll() {
        return daoActor.getAll();
    }
}
