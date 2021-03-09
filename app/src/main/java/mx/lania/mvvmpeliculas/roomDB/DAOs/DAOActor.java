package mx.lania.mvvmpeliculas.roomDB.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import mx.lania.mvvmpeliculas.roomDB.Entities.TableActor;

public interface DAOActor {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertarActor(TableActor nuevoActor);

    @Query("SELECT * FROM TableActor")
    LiveData<List<TableActor>> getAll();
}
