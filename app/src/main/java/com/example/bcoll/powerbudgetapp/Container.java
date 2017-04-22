package com.example.bcoll.powerbudgetapp;

/**
 * Created by bcoll on 3/13/2017.
 */

public class Container {
    int container_ID;

    String name;
    double amount;

    public int getContainer_ID() {
        return container_ID;
    }

    public void setContainer_ID(int container_ID) {
        this.container_ID = container_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
