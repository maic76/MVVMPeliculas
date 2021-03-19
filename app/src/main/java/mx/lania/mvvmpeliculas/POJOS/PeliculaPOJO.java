package mx.lania.mvvmpeliculas.POJOS;

public class PeliculaPOJO {
    private Integer id;
private String tituloPelicula;
private Integer anioEstreno;
private String poster;

public PeliculaPOJO(){

}
    public PeliculaPOJO(Integer id, String tituloPelicula, Integer anioEstreno, String poster) {
        this.id = id;
        this.tituloPelicula = tituloPelicula;
        this.anioEstreno = anioEstreno;
        this.poster = poster;
    }

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

    public Integer getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(Integer anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
