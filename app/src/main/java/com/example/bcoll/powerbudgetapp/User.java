package com.example.bcoll.powerbudgetapp;

/**
 * Created by bcoll on 3/13/2017.
 */

public class User {
    int user_id;
    String name;
    String password;


    public User(){

    }

    public User (String name, String pass){
        this.name = name;
        this.password = pass;
    }

    public void setID(int id) {
        this.user_id = id;
    }
    public int getID(){
        return this.user_id;
    }




    public void Name(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }


    public void setPassword(String pass){
        this.password = pass;
    }
    public String getPassword(){
        return this.password;
    }


}
