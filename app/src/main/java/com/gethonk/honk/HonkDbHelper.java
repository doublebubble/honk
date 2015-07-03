package com.gethonk.honk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.gethonk.honk.AlarmContract.AlarmEntry;

/**
 * Created by karan on 01/07/15.
 */
public class HonkDbHelper extends SQLiteOpenHelper {

    // If database schema is changed, increment this.
    private static final int DATABASE_VERSION = 0;

    private static final String DATABASE_NAME = "honk.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String DATETIME_TYPE = " DATETIME";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + AlarmEntry.TABLE_NAME + " (" +
                        AlarmEntry._ID + " INTEGER PRIMARY KEY " + COMMA_SEP +
                        AlarmEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                        AlarmEntry.COLUMN_NAME_SET_TIME + DATETIME_TYPE + COMMA_SEP +
                        AlarmEntry.COLUMN_NAME_ALARM_HOUR + INTEGER_TYPE + COMMA_SEP +
                        AlarmEntry.COLUMN_NAME_ALARM_MIN + INTEGER_TYPE + COMMA_SEP +
                        AlarmEntry.COLUMN_NAME_IS_ACTIVE + INTEGER_TYPE + COMMA_SEP +
                        AlarmEntry.COLUMN_NAME_REPEAT_AFTER + INTEGER_TYPE + COMMA_SEP +
                        AlarmEntry.COLUMN_NAME_REPEAT_COUNT + INTEGER_TYPE + COMMA_SEP +
                        AlarmEntry.COLUMN_NAME_SOUND + TEXT_TYPE + COMMA_SEP +
                        AlarmEntry.COLUMN_NAME_ACTIVE_RANGE + TEXT_TYPE + " )";
    private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + AlarmEntry.TABLE_NAME;

    public HonkDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}

