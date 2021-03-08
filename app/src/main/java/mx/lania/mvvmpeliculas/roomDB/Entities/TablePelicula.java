package mx.lania.mvvmpeliculas.roomDB.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TablePelicula")
public class TablePelicula {
    @PrimaryKey( autoGenerate = true)
    @ColumnInfo(name = "idPelicula")
    private int idPelicula;

    @ColumnInfo( name ="tituloPelicula")
    private String tituloPelicula;

    @ColumnInfo(name="anioEstreno")
    private int anioEstreno;

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

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }
}
