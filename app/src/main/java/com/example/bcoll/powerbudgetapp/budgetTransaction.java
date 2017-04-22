package com.example.bcoll.powerbudgetapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class budgetTransaction extends Activity {
    private Button dashButton;
    private Button conductTransaction;

    private EditText rentSpentField;
    private EditText entSpentField;
    private EditText foodSpentField;

    private double rentSpent = 0;
    private double entSpent = 0;
    private double foodSpent = 0;

   int budgetCount;
    Database_Info db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_transaction);

        dashButton = (Button)findViewById(R.id.TransDashButton);
        conductTransaction = (Button)findViewById(R.id.makeTransButton);

        rentSpentField = (EditText)findViewById(R.id.rentTransField);
        entSpentField = (EditText)findViewById(R.id.entTransField);
        foodSpentField = (EditText)findViewById(R.id.foodTransField);

        db = new Database_Info(this);



        dashButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Dashboard.class));
            }
        });


        conductTransaction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                budgetCount = db.getBudgetCount();

                rentSpent = Double.parseDouble(rentSpentField.getText().toString());
                foodSpent = Double.parseDouble(foodSpentField.getText().toString());
                entSpent = Double.parseDouble(entSpentField.getText().toString());

                try{
                    rentSpent = Double.parseDouble(rentSpentField.getText().toString());
                    foodSpent = Double.parseDouble(foodSpentField.getText().toString());
                    entSpent = Double.parseDouble(entSpentField.getText().toString());
                }catch(NumberFormatException e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Error: You must input a valid numerical amount",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.show();
                }

                if(budgetCount < 1){
                    Toast toast = Toast.makeText(getApplicationContext(),"Error, there is no budget currently registered. Please create a budget before making any transactions",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.show();
                }
                else{
                    if(rentSpent < 0 || foodSpent < 0 || entSpent < 0) {
                        Toast toast = Toast.makeText(getApplicationContext(),"Error: You cannot input negative amounts",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP,0,0);
                        toast.show();

                    }
                    else{
                        Budget updatedBudget = new Budget();

                        updatedBudget.setRentSpent(rentSpent);
                        updatedBudget.setEntertainmentSpent(entSpent);
                        updatedBudget.setFoodSpent(foodSpent);

                        db.updateBudgetTransactions(updatedBudget);


                        Toast toast = Toast.makeText(getApplicationContext(),"New tranasction made \n" + db.getBudget(1).spendingReport(),Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP,0,0);
                        toast.show();
                    }


                }


            }
        });










    }



    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
   }

}
