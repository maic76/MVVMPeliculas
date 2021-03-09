package mx.lania.mvvmpeliculas.roomDB.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TableGenero")
public class TableGenero {

    @PrimaryKey( autoGenerate = true)
    @ColumnInfo(name = "idGenero")
    private int idGenero;

    @ColumnInfo( name ="nombreGenero")
    private String nombreGenero;

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
}
