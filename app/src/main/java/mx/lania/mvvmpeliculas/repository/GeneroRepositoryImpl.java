package mx.lania.mvvmpeliculas.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import mx.lania.mvvmpeliculas.roomDB.DAOs.DAOGenero;
import mx.lania.mvvmpeliculas.roomDB.Entities.TableGenero;


public class GeneroRepositoryImpl implements GeneroRepository{
    private DAOGenero daoGenero;

    @Inject
    GeneroRepositoryImpl(DAOGenero daoGenero) {
        this.daoGenero = daoGenero;
    }

    @Override
    public void insertarGenero(TableGenero nuevoGenero) {
        daoGenero.insertarGenero(nuevoGenero);
    }

    @Override
    public LiveData<List<TableGenero>> getAll() {
        return daoGenero.getAll();
    }
}
