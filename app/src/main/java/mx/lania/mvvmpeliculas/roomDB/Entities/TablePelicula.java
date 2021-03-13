package mx.lania.mvvmpeliculas.roomDB.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "TablePelicula")
public class TablePelicula {
    @PrimaryKey( autoGenerate = true)
    @ColumnInfo(name = "idPelicula")
    private int idPelicula;

    @ColumnInfo( name ="tituloPelicula")
    private String tituloPelicula;

    @ColumnInfo(name="anioEstreno")
    private int anioEstreno;

    @ColumnInfo(name="idGenero")
    private int idGenero;

    @ColumnInfo(name="portada")
    private String portada;

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public TablePelicula(){
    }

    @Ignore
    public TablePelicula(int idPelicula, String tituloPelicula, int anioEstreno, int idGenero, String portada) {
        this.idPelicula = idPelicula;
        this.tituloPelicula = tituloPelicula;
        this.anioEstreno = anioEstreno;
        this.idGenero = idGenero;
        this.portada = portada;
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

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }
}
