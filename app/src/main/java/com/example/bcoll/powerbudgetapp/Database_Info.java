package com.example.bcoll.powerbudgetapp;
/**
 * Created by bcoll on 3/13/2017.
 */
import java.util.ArrayList;
import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

public class Database_Info extends SQLiteOpenHelper {
    private static final String DB_Name = "Budget_Database";
    private static final int DB_Version = 1;

    public Database_Info (Context context) {
        super(context,DB_Name,null,DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }










}
