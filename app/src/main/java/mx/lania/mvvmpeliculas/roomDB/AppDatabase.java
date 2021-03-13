package mx.lania.mvvmpeliculas.roomDB;

import androidx.room.RoomDatabase;

import mx.lania.mvvmpeliculas.roomDB.DAOs.DAOActor;
import mx.lania.mvvmpeliculas.roomDB.DAOs.DAOGenero;
import mx.lania.mvvmpeliculas.roomDB.DAOs.DAOPelicula;

public abstract class AppDatabase extends RoomDatabase {

    public static final String DB_NAME="db_peliculas";

    public abstract DAOPelicula getDAOPelicula();

    public abstract DAOGenero getDAOGenero();

    public abstract DAOActor getDAOActor();

}
