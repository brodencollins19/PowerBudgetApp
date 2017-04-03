package com.example.bcoll.powerbudgetapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class Dashboard extends Activity {

    Button transButton;
    Button budgetButton;
    Button reportButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        budgetButton=(Button)findViewById(R.id.budgetButton);
        reportButton=(Button)findViewById(R.id.reportButton);
        transButton=(Button)findViewById(R.id.transButton);


        budgetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_input_user_info);
            }
        });

        transButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_budget_transaction);
            }
        });


        reportButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_generate__report);
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
