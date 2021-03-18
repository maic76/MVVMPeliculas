package mx.lania.mvvmpeliculas;

import android.app.Application;

import mx.lania.mvvmpeliculas.di.AppComponent;
import mx.lania.mvvmpeliculas.di.RemoteModule;
import mx.lania.mvvmpeliculas.di.RepositoriesModule;
import  mx.lania.mvvmpeliculas.di.DaggerAppComponent;
import mx.lania.mvvmpeliculas.di.RoomModule;

public class MVVMPeliculas extends Application {

    AppComponent appComponent;

public void onCreate() {
    super.onCreate();

    appComponent = DaggerAppComponent
            .builder()
            .repositoriesModule(new RepositoriesModule(this))
            .roomModule(new RoomModule(this))
            .remoteModule(new RemoteModule(this))
            .build();
}
    public AppComponent getAppComponent(){
        return appComponent;
    }
}
