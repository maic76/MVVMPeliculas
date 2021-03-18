package mx.lania.mvvmpeliculas.remote.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PeliculaResponse {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tituloPelicula")
    @Expose
    private String tituloPelicula;
    @SerializedName("anioEstreno")
    @Expose
    private String anioEstreno;
    @SerializedName("poster")
    @Expose
    private String poster;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public String getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(String anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

}
