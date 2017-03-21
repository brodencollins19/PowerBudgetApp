package com.example.bcoll.powerbudgetapp;

/**
 * Created by bcoll on 3/13/2017.
 */

public class User {
    int user_id;
    String firstName;
    String lastName;
    String password;


    public User(){
        this.user_id = 0;
        this.firstName = "";
        this.lastName = "";
        //this.

    }

    public User (int id, String first, String last, String pass){
        this.user_id = id;
        this.firstName = first;
        this.lastName = last;
        this.password = pass;
    }

    public void setID(int id) {
        this.user_id = id;
    }
    public int getID(){
        return this.user_id;
    }


    public void setFirstName(String first){
        this.firstName = first;
    }
    public String getFirstName(){
        return this.firstName;
    }


    public void setLastName(String last){
        this.lastName = last;
    }
    public String getLastName(){
        return this.lastName;
    }


    public void setPassword(String pass){
        this.password = pass;
    }
    public String getPassword(){
        return this.password;
    }


}
