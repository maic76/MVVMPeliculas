package mx.lania.mvvmpeliculas.roomDB.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TableActor")
public class TableActor {

    @PrimaryKey( autoGenerate = true)
    @ColumnInfo(name = "idActor")
    private int idActor;

    @ColumnInfo( name ="nombreActor")
    private String nombreActor;

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
    }
}
