package mx.lania.mvvmpeliculas.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mx.lania.mvvmpeliculas.MVVMPeliculas;
import mx.lania.mvvmpeliculas.repository.PeliculaRepository;

@Module
public class RepositoriesModule {
    private final MVVMPeliculas application;

    public RepositoriesModule(MVVMPeliculas application) {
        this.application = application;
    }

    @Provides
    @Singleton
    PeliculaRepository providePeliculaRepository(PeliculaRepository repository){
        return repository;
    }

}
