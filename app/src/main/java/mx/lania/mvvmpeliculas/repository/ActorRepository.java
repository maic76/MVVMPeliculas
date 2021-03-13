package mx.lania.mvvmpeliculas.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import mx.lania.mvvmpeliculas.roomDB.Entities.TableActor;

public interface ActorRepository {
    void insertarActor(TableActor nuevoActor);

    LiveData<List<TableActor>> getAll();
}
