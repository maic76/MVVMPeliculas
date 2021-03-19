package mx.lania.mvvmpeliculas.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import mx.lania.mvvmpeliculas.UI.fragments.FragmentPelicula;

@Singleton
@Component( modules = {
        RepositoriesModule.class,
        RoomModule.class,
        RemoteModule.class
})
public interface AppComponent {
    Application application();
    void inject(FragmentPelicula fragmentPelicula);
}
