package com.example.bcoll.powerbudgetapp;

/**
 * Created by bcoll on 3/13/2017.
 */

public class User {
    long user_id;
    String name;
    String password;


    public User(){
        this.user_id = 0;
        this.name = null;
        this.password = null;
    }

    public User (String name, String pass){
        this.name = name;
        this.password = pass;
    }

    public User (long id, String name, String pass){
        this.user_id = id;
        this.name = name;
        this.password = pass;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String toString(){
        String info = "User ID: " + user_id +
                      "\nUser Name: " + name +
                      "\nUser Password: " + password;
        return info;
    }
}


