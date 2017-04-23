package com.example.bcoll.powerbudgetapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.TextView;




public class Generate_Report extends Activity {
    private Button dashButton;
    private Button reportButton;
    private TextView reportField;
    private ImageView incentiveImg;


    double initialTotal = 0;
    double savings = 0;
    double initialRent = 0;
    double initialEnt = 0;
    double initialFood = 0;

    double totalSpent = 0;
    double rentSpent = 0;
    double entSpent = 0;
    double foodSpent = 0;



    int budgetCount;
    Database_Info db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate__report);

        dashButton = (Button)findViewById(R.id.ReportDashButton);
        reportButton = (Button)findViewById(R.id.ReportGenButton);

        reportField = (TextView)findViewById(R.id.Report);

        incentiveImg = (ImageView)findViewById(R.id.incentiveImg);

        db = new Database_Info(this);


        dashButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Dashboard.class));
            }
        });

        reportButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String reportString = "";
                String conclusionString = "";

                budgetCount = db.getBudgetCount();

                if(budgetCount < 1){
                    Toast toast = Toast.makeText(getApplicationContext(),"Error, there is no budget currently registered. Please create a budget before trying to generate a report",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.show();
                }
                else{
                    Budget budget = db.getBudget(1);

                    initialTotal = budget.getTotalAmount();

                    initialRent = budget.getRentSpent();
                     initialEnt = budget.getEntertainementAmount();
                     initialFood = budget.getFoodAmount();

                     totalSpent = (rentSpent + entSpent + foodSpent);
                     rentSpent = budget.getRentSpent();
                     entSpent = budget.getEntertainmentSpent();
                     foodSpent = budget.getEntertainmentSpent();


                    if((initialTotal - totalSpent) < 0){
                        savings = 0;
                    }
                    else{
                        savings = initialTotal - totalSpent;
                    }


                    reportString = "Final report for " + db.getUser(1).getName() +":\n " + budget.toString() + "\n\n Final Savings: " + savings;
                    reportField.setText(reportString);

                    if(totalSpent > initialTotal){
                        Toast toast = Toast.makeText(getApplicationContext(),"Error: You have overspent for your whole budget: \n Initial allotment :"
                                + initialTotal + "\n Total Spent: " + totalSpent  +"\n If you have savings you may reallocate them in the Budget Information page",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP,0,0);
                        toast.show();
                        incentiveImg.setImageResource(R.drawable.alert);
                    }
                    else if(rentSpent > initialRent){
                        Toast toast = Toast.makeText(getApplicationContext(),"Error: You have overspent for your rent budget: \n Initial allotment :"
                                + initialRent + "\n Total Spent: " + rentSpent  +"\n If you have savings you may reallocate them in the Budget Information page",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP,0,0);
                        toast.show();
                        incentiveImg.setImageResource(R.drawable.alert);
                    }
                    else if(entSpent > initialEnt){
                        Toast toast = Toast.makeText(getApplicationContext(),"Error: You have overspent for your entertainment budget: \n Initial allotment :"
                                + initialEnt + "\n Total Spent: " + entSpent  +"\n If you have savings you may reallocate them in the Budget Information page",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP,0,0);
                        toast.show();
                        incentiveImg.setImageResource(R.drawable.alert);
                    }
                    else if(foodSpent > initialFood){
                        Toast toast = Toast.makeText(getApplicationContext(),"Error: You have overspent for your food budget: \n Initial allotment :"
                                + initialFood + "\n Total Spent: " + foodSpent  +"\n If you have savings you may reallocate them in the Budget Information page",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP,0,0);
                        toast.show();
                        incentiveImg.setImageResource(R.drawable.alert);

                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(),"Congratulations, you are in complete budget compliance! Thank you for using PowerBudget!",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP,0,0);
                        toast.show();

                        if(savings >= 50 && savings < 100){
                            incentiveImg.setImageResource(R.drawable.silver_badge);
                        }
                        else if(savings >= 100){
                            incentiveImg.setImageResource(R.drawable.gold_badge);
                        }
                        else{
                            incentiveImg.setImageResource(R.drawable.bronze_badge);
                        }
                    }

                    Budget saveBudget = new Budget();
                    saveBudget.setTotalSavings(savings);
                    db.updateBudgetSavings(saveBudget);







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
