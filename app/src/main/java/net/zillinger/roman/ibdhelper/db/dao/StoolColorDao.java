package net.zillinger.roman.ibdhelper.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import net.zillinger.roman.ibdhelper.db.entity.StoolColor;

import java.util.List;

@Dao
public interface StoolColorDao {

    @Insert
    void insertAll(List<StoolColor> entries);
}