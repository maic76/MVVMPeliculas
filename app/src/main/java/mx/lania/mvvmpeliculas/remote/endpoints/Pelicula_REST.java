package mx.lania.mvvmpeliculas.remote.endpoints;

import java.util.List;

import mx.lania.mvvmpeliculas.remote.models.PeliculaResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Pelicula_REST {
    @GET("peliculas")
    Call<List<PeliculaResponse>> getPeliculas();
}
