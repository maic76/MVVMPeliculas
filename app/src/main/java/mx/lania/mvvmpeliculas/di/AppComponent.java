package mx.lania.mvvmpeliculas.di;

import dagger.Component;

@Component( modules = {
        RepositoriesModule.class,
        RoomModule.class,
        RemoteModule.class
})
public interface AppComponent {
    //Application application();
}
