package mx.lania.mvvmpeliculas.roomDB.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import mx.lania.mvvmpeliculas.roomDB.Entities.TablePelicula;

@Dao
public interface DAOPelicula {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertarPelicula(TablePelicula nuevaPelicula);

    @Update
    void actualizarPelicula(TablePelicula actualizaPelicula);

    @Query("SELECT * FROM TablePelicula")
    List<TablePelicula> getPeliculasLocales();

    @Query("SELECT id FROM TablePelicula WHERE id =:idPelicula LIMIT 1")
    int getPeliculaById(int idPelicula);

    @Query("SELECT * FROM TablePelicula")
    LiveData<List<TablePelicula>> getAll();
}
