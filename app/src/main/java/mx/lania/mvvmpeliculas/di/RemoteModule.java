package mx.lania.mvvmpeliculas.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mx.lania.mvvmpeliculas.MVVMPeliculas;
import mx.lania.mvvmpeliculas.remote.endpoints.Pelicula_REST;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RemoteModule {

    private final MVVMPeliculas application;

    public RemoteModule(MVVMPeliculas application){
        this.application=application;
    }

    //-------- URL REST ------------------//

    public final static String BASE_URL = "https://api-peliculas-node.herokuapp.com/";

    @Provides
    MVVMPeliculas provideMVVMPeliculas(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }

    @Provides
    @Singleton
    Pelicula_REST providePeliculaWebService(){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(Pelicula_REST.class);
    }
}
