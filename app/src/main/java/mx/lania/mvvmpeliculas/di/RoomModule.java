package mx.lania.mvvmpeliculas.di;

import android.app.Application;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mx.lania.mvvmpeliculas.roomDB.AppDatabase;
import mx.lania.mvvmpeliculas.roomDB.DAOs.DAOActor;
import mx.lania.mvvmpeliculas.roomDB.DAOs.DAOGenero;
import mx.lania.mvvmpeliculas.roomDB.DAOs.DAOPelicula;

@Module
public class RoomModule {

    private final AppDatabase database;

    public RoomModule(Application application){
        database = Room.databaseBuilder(application, AppDatabase.class, AppDatabase.DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase (Application application){return database;}

    @Provides
    @Singleton
    DAOPelicula providePelicula(AppDatabase appDatabase){return appDatabase.getDAOPelicula();}

    @Provides
    @Singleton
    DAOGenero provideGenero(AppDatabase appDatabase){return appDatabase.getDAOGenero();}

    @Provides
    @Singleton
    DAOActor provideActor(AppDatabase appDatabase){return appDatabase.getDAOActor();}
}
