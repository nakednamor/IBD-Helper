package net.zillinger.roman.ibdhelper.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import net.zillinger.roman.ibdhelper.db.entity.BristolEntry;

import java.util.List;

@Dao
public interface BristolScaleDao {

    @Insert
    public void insertAll(List<BristolEntry> entries);
}