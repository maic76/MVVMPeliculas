package mx.lania.mvvmpeliculas.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import mx.lania.mvvmpeliculas.roomDB.Entities.TablePelicula;

public interface PeliculaRepository {

    void insertarPelicula(TablePelicula nuevaPelicula);

    LiveData<List<TablePelicula>> getAll();
}
