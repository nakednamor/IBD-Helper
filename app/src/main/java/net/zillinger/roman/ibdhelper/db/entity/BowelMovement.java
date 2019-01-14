package net.zillinger.roman.ibdhelper.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "bowelmovement", indices = {@Index("time"), @Index("bristolscale")},
        foreignKeys = @ForeignKey(entity = BristolEntry.class,
                parentColumns = "id",
                childColumns = "bristolscale"))
public class BowelMovement {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "time")
    private Date time;

    @ColumnInfo(name = "bristolscale")
    private int bristol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getBristol() {
        return bristol;
    }

    public void setBristol(int bristol) {
        this.bristol = bristol;
    }
}