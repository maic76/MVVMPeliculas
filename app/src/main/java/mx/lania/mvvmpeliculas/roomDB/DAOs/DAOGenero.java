package mx.lania.mvvmpeliculas.roomDB.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import mx.lania.mvvmpeliculas.roomDB.Entities.TableGenero;

@Dao
public interface DAOGenero {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertarGenero(TableGenero nuevoGenero);

    @Query("SELECT * FROM TableGenero")
    LiveData<List<TableGenero>> getAll();
}
