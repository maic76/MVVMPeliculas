package mx.lania.mvvmpeliculas.roomDB.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import mx.lania.mvvmpeliculas.roomDB.Entities.TablePelicula;

@Dao
public interface DAOPelicula {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertarPelicula(TablePelicula nuevaPelicula);

    @Query("SELECT * FROM TablePelicula")
    LiveData<List<TablePelicula>> getAll();
}
