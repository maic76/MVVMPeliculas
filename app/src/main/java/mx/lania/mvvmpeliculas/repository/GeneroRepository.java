package mx.lania.mvvmpeliculas.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import mx.lania.mvvmpeliculas.roomDB.Entities.TableGenero;

public interface GeneroRepository {
    void insertarGenero(TableGenero nuevoGenero);

    LiveData<List<TableGenero>> getAll();
}
