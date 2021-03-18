package mx.lania.mvvmpeliculas.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import mx.lania.mvvmpeliculas.roomDB.Entities.TablePelicula;

public interface PeliculaRepository {

    void insertarPelicula(TablePelicula nuevaPelicula);

    int getPeliculaById(int idPelicula);

    void actualizarPelicula(TablePelicula actualizaPelicula);

    LiveData<List<TablePelicula>> getPeliculasLocales();

    LiveData<List<TablePelicula>> getAll();
}
