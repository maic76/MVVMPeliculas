package mx.lania.mvvmpeliculas.roomDB.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "TablePelicula")
public class TablePelicula {
    @PrimaryKey( autoGenerate = true)
    @ColumnInfo(name = "id")
    private int idPelicula;

    @ColumnInfo( name ="tituloPelicula")
    private String tituloPelicula;

    @ColumnInfo(name="anioEstreno")
    private int anioEstreno;

   /* @ColumnInfo(name="idGenero")
    private int idGenero;*/

    @ColumnInfo(name="poster")
    private String poster;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public TablePelicula(){
    }

    @Ignore
    public TablePelicula(int idPelicula, String tituloPelicula, int anioEstreno,  String poster) {
        this.idPelicula = idPelicula;
        this.tituloPelicula = tituloPelicula;
        this.anioEstreno = anioEstreno;
      /*  this.idGenero = idGenero;*/
        this.poster = poster;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

  /*  public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }*/

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }
}
