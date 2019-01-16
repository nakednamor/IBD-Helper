package net.zillinger.roman.ibdhelper.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity(tableName = "bowelmovement", indices = {@Index(value = "time", unique = true), @Index("bristolscale"), @Index("stoolcolor")},
        foreignKeys = {
                @ForeignKey(entity = BristolEntry.class, parentColumns = "id", childColumns = "bristolscale"),
                @ForeignKey(entity = StoolColor.class, parentColumns = "id", childColumns = "stoolcolor")
        }
)
public class BowelMovement {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "time")
    private Date time;

    @NonNull
    @ColumnInfo(name = "bristolscale")
    private int bristol;

    @ColumnInfo(name = "blood")
    private Boolean blood = false;

    @ColumnInfo(name = "mucus")
    private Boolean mucus = false;

    @ColumnInfo(name = "stoolcolor")
    private Integer stoolColor;

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

    public Boolean getBlood() {
        return blood;
    }

    public void setBlood(Boolean blood) {
        this.blood = blood;
    }

    public Boolean getMucus() {
        return mucus;
    }

    public Integer getStoolColor() {
        return stoolColor;
    }

    public void setStoolColor(Integer stoolColor) {
        this.stoolColor = stoolColor;
    }

    public void setMucus(Boolean mucus) {
        this.mucus = mucus;


    }
}