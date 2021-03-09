package mx.lania.mvvmpeliculas.di;

import androidx.lifecycle.ViewModelProvider;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mx.lania.mvvmpeliculas.MVVMPeliculas;
import mx.lania.mvvmpeliculas.repository.ActorRepository;
import mx.lania.mvvmpeliculas.repository.GeneroRepository;
import mx.lania.mvvmpeliculas.repository.PeliculaRepository;
import mx.lania.mvvmpeliculas.viewModel.GeneroViewModelFactory;
import mx.lania.mvvmpeliculas.viewModel.PeliculaViewModelFactory;

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

    @Provides
    @Singleton
    GeneroRepository provideGeneroRepository(GeneroRepository repository){
        return repository;
    }


    @Provides
    @Singleton
    ActorRepository provideActorRepository(ActorRepository repository){
        return repository;
    }

    @Provides
    @Singleton
    @Named("PeliculaFactory")
    ViewModelProvider.Factory providePeliculaViewModelFactory(PeliculaRepository repository){
        return new PeliculaViewModelFactory(repository);
    }

    @Provides
    @Singleton
    @Named("GeneroFactory")
    ViewModelProvider.Factory provideGeneroViewModelFactory(GeneroRepository repository){
        return new GeneroViewModelFactory(repository);
    }

}
