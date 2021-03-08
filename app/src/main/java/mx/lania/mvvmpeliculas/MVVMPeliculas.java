package mx.lania.mvvmpeliculas;

import android.app.Application;

import mx.lania.mvvmpeliculas.di.AppComponent;
import mx.lania.mvvmpeliculas.di.RepositoriesModule;
import  mx.lania.mvvmpeliculas.di.DaggerAppComponent;

public class MVVMPeliculas extends Application {

    AppComponent appComponent;

public void onCreate() {
    super.onCreate();

    appComponent = DaggerAppComponent
            .builder()
            .repositoriesModule(new RepositoriesModule(this))
            .build();
}
    public AppComponent getAppComponent(){
        return appComponent;
    }
}
