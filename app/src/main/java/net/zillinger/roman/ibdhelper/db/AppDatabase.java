package net.zillinger.roman.ibdhelper.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;

import net.zillinger.roman.ibdhelper.db.dao.BowelMovementDao;
import net.zillinger.roman.ibdhelper.db.dao.BristolScaleDao;
import net.zillinger.roman.ibdhelper.db.dao.StoolColorDao;
import net.zillinger.roman.ibdhelper.db.entity.BowelMovement;
import net.zillinger.roman.ibdhelper.db.entity.BristolEntry;
import net.zillinger.roman.ibdhelper.db.entity.Converters;
import net.zillinger.roman.ibdhelper.db.entity.StoolColor;

import java.util.concurrent.Executors;

@Database(entities = {BowelMovement.class, BristolEntry.class, StoolColor.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract BowelMovementDao bowelMovementDao();

    public abstract BristolScaleDao bristolScaleDao();

    public abstract StoolColorDao stoolColorDao();

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "ibdhelper_database")
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            getDatabase(context).bristolScaleDao().insertAll(BristolEntry.populateDate());
                                        }
                                    });
                                }
                            })
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}