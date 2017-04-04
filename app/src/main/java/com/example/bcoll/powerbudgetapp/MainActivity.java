package com.example.bcoll.powerbudgetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText userName;
    EditText password;
    Button loginButton;
    Database_Info db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName=(EditText)findViewById(R.id.userNameField);
        password=(EditText)findViewById(R.id.userPassField);
        loginButton=(Button)findViewById(R.id.loginButton);
        db = new Database_Info(this);


        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               String nameString = userName.getText().toString();
               String passString = password.getText().toString();

                if(passString.isEmpty() || nameString.isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.show();
                }
                else{
                    User newUser = new User(nameString, passString);
                    db.addUser(newUser);
                    startActivity(new Intent(getApplicationContext(),Dashboard.class));
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
