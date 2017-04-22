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
    Button addUserButton;

    String nameString;
    String passString;

    Database_Info db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getApplicationContext().deleteDatabase("Budget_Database");  //Flushes sql data after each run of the application

        userName=(EditText)findViewById(R.id.userNameField);
        password=(EditText)findViewById(R.id.userPassField);


        addUserButton = (Button)findViewById(R.id.addUSerButton);
        loginButton=(Button)findViewById(R.id.loginButton);

        db = new Database_Info(this);


        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nameString = userName.getText().toString();
                passString = password.getText().toString();

                int userCount = db.getUserCount();

                if(userCount < 1){
                    Toast toast = Toast.makeText(getApplicationContext(),"Error: There is no user added, please click Add User to register",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.show();
                }
                else{
                    User loginUser = db.getUser(1);
                    if(passString.compareTo(loginUser.getPassword()) != 0 || nameString.compareTo(loginUser.getName()) !=0){
                        Toast toast = Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.TOP,0,0);
                        toast.show();
                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(),"Thank you " + loginUser.getName() + " Welcome to PowerBudget",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.TOP,0,0);
                        toast.show();
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                    }

                }

            }
        });


        addUserButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                nameString = userName.getText().toString();
                passString = password.getText().toString();

                int userCount = db.getUserCount();

                User newUser = new User(nameString,passString);

                if(userCount >= 1){
                    Toast toast = Toast.makeText(getApplicationContext(), "Only one user supported at this time, Please close the app to refresh \n or click login to proceed" ,Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.show();
                }
                else{
                    db.addUser(newUser);
                    User addedUser = db.getUser(1);
                    Toast toast = Toast.makeText(getApplicationContext(),"Congratulations, New User Registered: \n" +
                            addedUser.toString() + "\n Please click login to enter the application\"" ,Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.show();

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
