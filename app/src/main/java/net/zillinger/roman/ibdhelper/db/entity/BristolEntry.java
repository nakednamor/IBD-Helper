package net.zillinger.roman.ibdhelper.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Arrays;
import java.util.List;

@Entity(tableName = "bristolscale")
public class BristolEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "info")
    private String image;

    public BristolEntry(String type, String image) {
        this.type = type;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static List<BristolEntry> populateDate() {
        return Arrays.asList(
                new BristolEntry("type 1", "type_1.png"),
                new BristolEntry("type 2", "type_2.png"),
                new BristolEntry("type 3", "type_3.png"),
                new BristolEntry("type 4", "type_4.png"),
                new BristolEntry("type 5", "type_5.png"),
                new BristolEntry("type 6", "type_6.png"),
                new BristolEntry("type 7", "type_7.png")
        );
    }
}