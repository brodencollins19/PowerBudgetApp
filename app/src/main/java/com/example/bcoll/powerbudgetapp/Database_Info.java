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
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

public class Database_Info extends SQLiteOpenHelper {
    private static final String DB_Name = "Budget_Database";
    private static final int DB_Version = 1;        //   -Probs dont need this */

    // Table Names //
    private final String TABLE_USER = "User";
    private final String TABLE_BUDGET  = "Budget";


    // User Columz z.findby od = 2
    private final String USER_ID = "_id";
    private final String USER_NAME = "name";
    private final String USER_PASSWORD = "password";

    // Budget Columens
    private final String BUDGET_ID = "_id";
    private final String BUDGET_AMOUNT = "totalAmount";
    private final String BUDGET_SAVINGS = "totalSavings";

    private final String BUDGET_RENT = "rentAmount";
    private final String BUDGET_ENTERTAINMENT = "entertainmentAmount";
    private final String BUDGET_FOOD = "foodAmount";

    private final String BUDGET_RENT_SPENT = "rentSpent";
    private final String BUDGET_ENTERTAINMENT_SPENT = "entertainmentSpent";
    private final String BUDGET_FOOD_SPENT = "foodSpent";

    // Lists of coumns nmaes for query statements
    private final String[] userColumns = {USER_ID,USER_NAME,USER_PASSWORD};
    private final String[] budgetColumns = {BUDGET_ID,BUDGET_AMOUNT,BUDGET_SAVINGS,BUDGET_RENT,BUDGET_ENTERTAINMENT,BUDGET_FOOD,BUDGET_RENT_SPENT,BUDGET_ENTERTAINMENT_SPENT,BUDGET_FOOD_SPENT};


    //Table create statements

    private String create_User_Table = "CREATE TABLE " + TABLE_USER + "( " +
            USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_NAME + " TEXT NOT NULL, " +
            USER_PASSWORD + " TEXT NOT NULL);";


    private String create_Budget_Table = "CREATE TABLE " + TABLE_BUDGET + "( " +
            BUDGET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BUDGET_AMOUNT + " DOUBLE NOT NULL, " +
            BUDGET_SAVINGS +" DOUBLE NOT NULL, " + BUDGET_RENT + " DOUBLE NOT NULL, " + BUDGET_ENTERTAINMENT + " DOUBLE NOT NULL, " +
            BUDGET_FOOD + " DOUBLE NOT NULL, " + BUDGET_RENT_SPENT + " DOUBLE NOT NULL, " + BUDGET_ENTERTAINMENT_SPENT + " DOUBLE NOT NULL, "
            + BUDGET_FOOD_SPENT + " DOUBLE NOT NULL);";


    public Database_Info (Context context) {
        super(context,DB_Name,null,DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //db.execSQL("CREATE TABLE USER (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, password TEXT NOT NULL");d
        db.execSQL(create_User_Table);
       db.execSQL(create_Budget_Table);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Users, Budget, Container, Transaction");
        onCreate(db);
    }
    /*
      The following code represents operations to manipulate tables in the database
      These methods will be used to insert and retwieve data from the datbases
     */

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_NAME,user.getName());
        values.put(USER_PASSWORD,user.getPassword());
        db.insert(TABLE_USER,null,values);
        db.close();
    }


    public User getUser(long id){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TABLE_USER,userColumns,USER_ID + " =?",new String[]{String.valueOf(id)},null,null,null,null);

        if (c != null)
            c.moveToFirst();

        User user = new User(Long.parseLong(c.getString(0)),c.getString(1),c.getString(2));
        c.close();
        return user;


    }


    public int getUserCount(){

        int count = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USER;
        Cursor c = db.rawQuery(query,null);

        count = c.getCount();

        c.close();

        return count;


    }


    public void addBudget(Budget budget){

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(BUDGET_AMOUNT,budget.getTotalAmount());                               //Adds a new bedgut to the database
            values.put(BUDGET_SAVINGS,0);

            values.put(BUDGET_RENT,budget.getRentAmount());
            values.put(BUDGET_ENTERTAINMENT,budget.getFoodAmount());
            values.put(BUDGET_FOOD,budget.getFoodAmount());

            values.put(BUDGET_RENT_SPENT,budget.getRentSpent());
            values.put(BUDGET_ENTERTAINMENT_SPENT,budget.getEntertainmentSpent());
            values.put(BUDGET_FOOD_SPENT,budget.getFoodSpent());

            db.insert(TABLE_BUDGET,null,values);
            db.close();
    }


    public Budget getBudget(long id){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TABLE_BUDGET,budgetColumns,USER_ID + " =?",new String[]{String.valueOf(id)},null,null,null,null);


        if (c != null)
            c.moveToFirst();


        Budget budget = new Budget(Long.parseLong(c.getString(0)),Double.parseDouble(c.getString(1)),Double.parseDouble(c.getString(2)),Double.parseDouble(c.getString(3)),Double.parseDouble(c.getString(4)),Double.parseDouble(c.getString(5)),Double.parseDouble(c.getString(6)),Double.parseDouble(c.getString(7)),Double.parseDouble(c.getString(8)));
        c.close();
        return budget;

    }

    public int getBudgetCount(){
        int count = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_BUDGET;
        Cursor c = db.rawQuery(query,null);

        count = c.getCount();

        c.close();

        return count;
    }




    public void updateBudgetTotal(Budget budget){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put(BUDGET_AMOUNT,budget.getTotalAmount());                               //Adds a new bedgut to the database
        values.put(BUDGET_SAVINGS,0);

        values.put(BUDGET_RENT,budget.getRentAmount());
        values.put(BUDGET_ENTERTAINMENT,budget.getEntertainementAmount());
        values.put(BUDGET_FOOD,budget.getFoodAmount());

        db.update(TABLE_BUDGET, values, BUDGET_ID + " =?", new String[] {String.valueOf(1) });

    }

    public void updateBudgetTransactions(Budget budget){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put(BUDGET_RENT_SPENT,budget.getRentSpent());
        values.put(BUDGET_ENTERTAINMENT_SPENT,budget.getEntertainmentSpent());
        values.put(BUDGET_FOOD_SPENT,budget.getFoodSpent());

        db.update(TABLE_BUDGET, values, BUDGET_ID + " =?", new String[] {String.valueOf(1) });

    }





}
