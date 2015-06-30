package com.gethonk.honk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by karan on 01/07/15.
 */
public class HonkDbHelper extends SQLiteOpenHelper {

    // if database schema is changed, increment
    private static final int DATABASE_VERSION = 0;

    static final String DATABASE_NAME = "honk.db";

    public HonkDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_ALARM_TABLE = "CREATE TABLE ";

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

