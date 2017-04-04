package com.example.bcoll.powerbudgetapp;
/**
 * Created by bcoll on 3/13/2017.
 */
import java.util.ArrayList;

/*
Java drivers for sqlite interaction with Android
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.List;

public class Database_Info extends SQLiteOpenHelper {
    private static final String DB_Name = "Budget_Database";
    private static final int DB_Version = 1;        //   -Probs dont need this */

    // Table Names //
    private final String TABLE_USER = "User";
    private final String TABLE_BUDGET  = "Budget";
    private final String TABLE_CONTAINER = "Container";
    private final String TABLE_TRANSACTION = "Transaction";


    // User Columns
    private final String USER_ID = "userID";
    private final String USER_NAME = "name";
    private final String USER_PASSWORD = "password";

    // Budget Columens
    private final String BUDGET_ID = "budgetID";
    private final String BUDGET_AMOUNT = "totalAmount";
    private final String BUDGET_SAVINGS = "totalSavings";
    private final String BUDGET_USER_FK = "userID_FK";

    // Container Columns
    private final String CONTAINER_ID = "containerID";
    private final String CONTAINER_NAME = "containerName";
    private final String CONTAINER_AMOUNT = "containerAmount";
    private final String CONTAINER_BUDGET_FK = "budgetID_FK";

    //Transaction Columns






    //Table create statements

    private String create_User_Table = "CREATE TABLE " + TABLE_USER + "( " +
            USER_ID + " INT PRIMARY KEY NOT NULL, " + USER_NAME + " TEXT NOT NULL, " +
            USER_PASSWORD + " TEXT NOT NULL );";


    private String create_Budget_Table = "CREATE TABLE " + TABLE_BUDGET + "( " +
            BUDGET_ID + " INT PRIMARY KEY NOT NULL, " + BUDGET_AMOUNT + "DOUBLE NOT NULL, " +
            BUDGET_SAVINGS +"DOUBLE NOT NULL, " + "FOREIGN KEY (userID_FK) REFERENCES User(userID) );";


    private String create_Container_Table = "CREATE TABLE " + TABLE_CONTAINER + "( " +
                   CONTAINER_ID + " INT PRIMARY KEY NOT NULL, " + CONTAINER_NAME + " TEXT NOT NULL, " +
                   CONTAINER_AMOUNT + " DOUBLE NOT NULL, " + "FOREIGN KEY (budgetID_FK) REFERENCES Budget(budgetID) );";


    //private String create_Transaction_Table ="";



    public Database_Info (Context context) {
        super(context,DB_Name,null,DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("PRAGMA foreign_keys=ON;");
        db.execSQL(create_User_Table);
        //db.execSQL(create_Budget_Table);
        //db.execSQL(create_Container_Table);
      //  db.execSQL(create_Transaction_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Users, Budget, Container, Transaction");
        onCreate(db);
    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(USER_NAME,user.getName());
        values.put(USER_PASSWORD,user.getPassword());
        db.insert(TABLE_USER,null,values);
        db.close();
    }



   // public User getUser(int id){
      //  SQLiteDatabase db = this.getWritableDatabase();


    //}




    public void addBudget(Budget budget){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //values.put(BUDGET_AMOUNT,budg);

    }


   // public Budget getBudget(int id){

   // }

    public void addContainer(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "";

    }


    public void updateContainer(){

    }

    //public Container getContainer(int id){

   // }

    //public List<Container> getAllContainers(){

   // }














}
