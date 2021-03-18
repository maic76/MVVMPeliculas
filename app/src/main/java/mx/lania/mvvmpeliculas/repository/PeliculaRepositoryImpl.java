package mx.lania.mvvmpeliculas.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import mx.lania.mvvmpeliculas.roomDB.DAOs.DAOPelicula;
import mx.lania.mvvmpeliculas.roomDB.Entities.TablePelicula;

public class PeliculaRepositoryImpl implements PeliculaRepository {

    private DAOPelicula daoPelicula;

    @Inject
    PeliculaRepositoryImpl(DAOPelicula daoPelicula) {
        this.daoPelicula = daoPelicula;
    }

    @Override
    public void insertarPelicula(TablePelicula nuevaPelicula) {
         daoPelicula.insertarPelicula(nuevaPelicula);
    }

    @Override
    public int getPeliculaById(int idPelicula) {
        return daoPelicula.getPeliculaById(idPelicula);
    }

    @Override
    public void actualizarPelicula(TablePelicula actualizaPelicula) {
        daoPelicula.actualizarPelicula(actualizaPelicula);
    }

    @Override
    public LiveData<List<TablePelicula>> getPeliculasLocales() {
        final MutableLiveData<List<TablePelicula>> liveData = new MutableLiveData<>();
        liveData.setValue(daoPelicula.getPeliculasLocales());
        return liveData;
    }

    @Override
    public LiveData<List<TablePelicula>> getAll() {
        return daoPelicula.getAll();
    }
}
