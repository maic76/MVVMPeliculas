package mx.lania.mvvmpeliculas.roomDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import mx.lania.mvvmpeliculas.roomDB.DAOs.DAOActor;
import mx.lania.mvvmpeliculas.roomDB.DAOs.DAOGenero;
import mx.lania.mvvmpeliculas.roomDB.DAOs.DAOPelicula;
import mx.lania.mvvmpeliculas.roomDB.Entities.TableActor;
import mx.lania.mvvmpeliculas.roomDB.Entities.TableGenero;
import mx.lania.mvvmpeliculas.roomDB.Entities.TablePelicula;

@Database(entities = {
        TablePelicula.class
},version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DB_NAME="db_peliculas";

    public abstract DAOPelicula getDAOPelicula();

   /* public abstract DAOGenero getDAOGenero();

    public abstract DAOActor getDAOActor();*/

}
