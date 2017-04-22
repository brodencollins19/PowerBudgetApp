package com.example.bcoll.powerbudgetapp;

/**
 * Created by bcoll on 3/13/2017.
 */

public class Budget {
    private long budget_ID;

    private double totalAmount;
    private double totalSavings;

    private double rentAmount;
    private double entertainementAmount;
    private double foodAmount;

    private double rentSpent;
    private double entertainmentSpent;
    private double foodSpent;


    public Budget(){
        this.totalAmount = 0;
        this.totalSavings = 0;
        this.rentAmount = 0;
        this.entertainementAmount = 0;
        this.foodAmount = 0;
        this.rentSpent = 0;
        this.entertainmentSpent = 0;
        this.foodSpent = 0;

    }

    public Budget(double amount, double savings, double rent, double entertainment, double food, double rentSpent, double entertainmentSpent,double foodSpent){
        this.totalAmount = amount;
        this.totalSavings = savings;
        this.rentAmount = rent;
        this.entertainementAmount = entertainment;
        this.foodAmount = food;
        this.rentSpent = rentSpent;
        this.entertainmentSpent = entertainmentSpent;
        this.foodSpent = foodSpent;
    }


    public Budget(long id,double amount, double savings, double rent, double entertainment, double food, double rentSpent, double entertainmentSpent,double foodSpent){
        this.budget_ID = id;
        this.totalAmount = amount;
        this.totalSavings = savings;
        this.rentAmount = rent;
        this.entertainementAmount = entertainment;
        this.foodAmount = food;
        this.rentSpent = rentSpent;
        this.entertainmentSpent = entertainmentSpent;
        this.foodSpent = foodSpent;
    }


    public long getBudget_ID() {
        return budget_ID;
    }

    public void setBudget_ID(long budget_ID) {
        this.budget_ID = budget_ID;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings(double totalSavings) {
        this.totalSavings = totalSavings;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public double getEntertainementAmount() {
        return entertainementAmount;
    }

    public void setEntertainementAmount(double entertainementAmount) {
        this.entertainementAmount = entertainementAmount;
    }

    public double getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(double foodAmount) {
        this.foodAmount = foodAmount;
    }

    public double getRentSpent() {
        return rentSpent;
    }

    public void setRentSpent(double rentSpent) {
        this.rentSpent = rentSpent;
    }

    public double getEntertainmentSpent() {
        return entertainmentSpent;
    }

    public void setEntertainmentSpent(double entertainmentSpent) {
        this.entertainmentSpent = entertainmentSpent;
    }

    public double getFoodSpent() {
        return foodSpent;
    }

    public void setFoodSpent(double foodSpent) {
        this.foodSpent = foodSpent;
    }



    public String toString(){
        String report = "Budget ID: " + budget_ID +
                         "\nTotal Amount: $" + totalAmount +
                         "\nMoney Saved: $" + totalSavings +
                         "\nRent Allocation: $" + rentAmount +
                         "\nEntertainment Allocation: $" + entertainementAmount +
                         "\nFood Allocation $" + foodAmount +
                         "\nRent Activity: $" + rentSpent +
                         "\nEntertainment Activity: $" + entertainmentSpent +
                         "\nFood Actvity: $" + foodSpent;
        return report;
    }

    public String budgetReport(){
        String report = "Budget ID: " + budget_ID +
                "\nTotal Amount: $" + totalAmount +
                "\nMoney Saved: $" + totalSavings +
                "\nRent Allocation: $" + rentAmount +
                "\nEntertainment Allocation: $" + entertainementAmount +
                "\nFood Allocation $" + foodAmount;
        return report;
    }

    public String spendingReport(){
        String report = "Budget ID: " + budget_ID +
                "\nRent Activity: $" + rentSpent +
                "\nEntertainment Activity: $" + entertainmentSpent +
                "\nFood Actvity: $" + foodSpent;
        return report;
    }
}
