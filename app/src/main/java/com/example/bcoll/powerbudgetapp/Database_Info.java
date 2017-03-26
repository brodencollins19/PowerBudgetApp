package com.example.bcoll.powerbudgetapp;
/**
 * Created by bcoll on 3/13/2017.
 */
import java.util.ArrayList;

/*
Java drivers for sqlite interaction with Android
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

/*
  JAve utils for file IO
 */
import java.io.*;
import java.util.Scanner;

public class Database_Info extends SQLiteOpenHelper {
    private static final String DB_Name = "Budget_Database";
    private static final int DB_Version = 1;        //   -Probs dont need this */


    public Database_Info (Context context) {
        super(context,DB_Name,null,DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        Scanner dbScanner = null;
        String createTables = "";
        try{
            dbScanner = new Scanner(new File("res/dbScript"));
            while(dbScanner.hasNextLine()){
                createTables += dbScanner.nextLine() + "\n";
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            dbScanner.close();
        }
        db.execSQL(createTables);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Users, Budget, Incentive, Container, Transaction");
        onCreate(db);
    }


    public void addUser(){

    }


    public void addBudget(){

    }

    public void addIncentive(){

    }

    public void addContainer(){

    }

    public void addTranaction(){

    }












}
