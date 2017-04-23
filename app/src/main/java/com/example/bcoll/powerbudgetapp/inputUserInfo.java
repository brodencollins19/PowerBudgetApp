package com.example.bcoll.powerbudgetapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class inputUserInfo extends Activity {

    private double rentAmt = 0;
    private double foodAmt = 0;
    private double entertainmentAmt = 0;
    private double totalAmount = 0;
    private double savings = 0;

    private EditText totalField;
    private EditText rentField;
    private EditText entertainmentField;
    private EditText foodField;

    private Button dashButton;
    private Button createButton;
    private Button updateButton;
    private Button savingsButton;

    int budgetCount;

    Database_Info db;

    //private Te

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_user_info);

        totalField = (EditText) findViewById(R.id.TotalBudgetField);
        rentField = (EditText) findViewById(R.id.RentField);
        entertainmentField = (EditText) findViewById(R.id.EntertainmentField);
        foodField = (EditText) findViewById(R.id.FoodField);

        dashButton = (Button) findViewById(R.id.InfoDashButton);
        createButton = (Button) findViewById(R.id.NewBudget);
        updateButton = (Button) findViewById(R.id.UpdateBudget);
        savingsButton = (Button) findViewById(R.id.SavingsRealloc);

        db = new Database_Info(this);


        //budgetCount = db.getBudgetCount();

        dashButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Dashboard.class));

            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                budgetCount = db.getBudgetCount();

                try {
                    totalAmount = Double.parseDouble(totalField.getText().toString());
                    rentAmt = Double.parseDouble(rentField.getText().toString());
                    foodAmt = Double.parseDouble(foodField.getText().toString());
                    entertainmentAmt = Double.parseDouble(entertainmentField.getText().toString());
                } catch (NumberFormatException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Error: You must input a valid numerical amount", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                }

                if (budgetCount >= 1) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Error, PowerBudget only supports one user Budget at this time", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                } else {
                    if (rentAmt < 0 || foodAmt < 0 || entertainmentAmt < 0 || totalAmount < 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Error: You cannot input negative amounts", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP, 0, 0);
                        toast.show();

                    } else {
                        if (rentAmt + foodAmt + entertainmentAmt > totalAmount) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Error, Your initial container allotments cannot succeed the total budget amount", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP, 0, 0);
                            toast.show();
                        } else {
                            Budget budget = new Budget();
                            budget.setTotalAmount(totalAmount);
                            budget.setRentAmount(rentAmt);
                            budget.setFoodAmount(foodAmt);
                            budget.setEntertainementAmount(entertainmentAmt);

                            db.addBudget(budget);

                            Toast toast = Toast.makeText(getApplicationContext(), "New Budget Created:\n" + db.getBudget(1).toString(), Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP, 0, 0);
                            toast.show();

                        }
                    }


                }

            }
        });


        updateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                budgetCount = db.getBudgetCount();


                try {
                    totalAmount = Double.parseDouble(totalField.getText().toString());
                    rentAmt = Double.parseDouble(rentField.getText().toString());
                    foodAmt = Double.parseDouble(foodField.getText().toString());
                    entertainmentAmt = Double.parseDouble(entertainmentField.getText().toString());
                } catch (NumberFormatException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Error: You must input a valid numerical amount", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                }


                if (budgetCount < 1) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Error, there is no budget currently registered. Please create a budget berofre editing", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                } else {
                    if (rentAmt < 0 || foodAmt < 0 || entertainmentAmt < 0 || totalAmount < 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Error: You cannot input negative amounts", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP, 0, 0);
                        toast.show();

                    } else {
                        if (rentAmt + foodAmt + entertainmentAmt > totalAmount) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Error: Container allotments cannot succeed the total budget amount", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP, 0, 0);
                            toast.show();
                        } else {
                            Budget updatedBudget = new Budget();

                            updatedBudget.setTotalAmount(totalAmount);
                            updatedBudget.setRentAmount(rentAmt);
                            updatedBudget.setFoodAmount(foodAmt);
                            updatedBudget.setEntertainementAmount(entertainmentAmt);

                            db.updateBudgetTotal(updatedBudget);


                            Toast toast = Toast.makeText(getApplicationContext(), "Your Budget has been updated:\n" + db.getBudget(1).toString(), Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP, 0, 0);
                            toast.show();
                        }


                    }

                }
            }
        });


        savingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                budgetCount = db.getBudgetCount();

                try {
                    rentAmt = Double.parseDouble(rentField.getText().toString());
                    foodAmt = Double.parseDouble(foodField.getText().toString());
                    entertainmentAmt = Double.parseDouble(entertainmentField.getText().toString());
                } catch (NumberFormatException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Error: You must input a valid numerical amount", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                }

                if (budgetCount < 1) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Error, there is no budget currently registered. Please create a budget berofre editing", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                } else {
                    savings = db.getBudget(1).getTotalSavings();

                    if (rentAmt < 0 || foodAmt < 0 || entertainmentAmt < 0 || totalAmount < 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Error: You cannot input negative amounts", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP, 0, 0);
                        toast.show();

                    } else {
                        if ((rentAmt + foodAmt + entertainmentAmt > savings) || savings == 0) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Error: You are trying to redistribute $" + (rentAmt + foodAmt + entertainmentAmt) +
                                    " with only $" + savings + " in savings \n Any new container allotments created with savings funds cannot exceed the current savings total", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP, 0, 0);
                            toast.show();
                        } else {
                            Budget updatedBudget = new Budget();

                            updatedBudget.setRentAmount(rentAmt);
                            updatedBudget.setFoodAmount(foodAmt);
                            updatedBudget.setEntertainementAmount(entertainmentAmt);

                            db.updateBudgetTotal(updatedBudget);


                            Toast toast = Toast.makeText(getApplicationContext(), "Your Budget has been updated using savings funds:\n" + db.getBudget(1).toString(), Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP, 0, 0);
                            toast.show();
                        }

                    }


                }
            }

        });
    }

    @Override
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
        {
            super.onDestroy();
        }

    }
}
