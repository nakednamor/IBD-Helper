package net.zillinger.roman.ibdhelper.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import net.zillinger.roman.ibdhelper.db.entity.BowelMovement;

@Dao
public interface BowelMovementDao {

    @Insert
    long add(BowelMovement bowelMovement);
}