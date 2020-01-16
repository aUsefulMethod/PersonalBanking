package com.travissauer;

import java.text.DecimalFormat;

public abstract class BankAccount {

    private double balance;
    private int numOfDeposits = 0;
    private int numOfWithdrawals = 0;
    private double annualInterestRate;
    private int monthlyServiceCharges;

    DecimalFormat money = new DecimalFormat("$0.00");

    public BankAccount(int balance, double annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public void deposit(int depositAmount){

        this.balance += depositAmount;
        this.numOfWithdrawals++;

    }

    public void withdraw(int withdrawalAmount){

        this.balance -= withdrawalAmount;
        this.numOfWithdrawals++;

    }

    public double calcInterest(){

        double monthlyInterestRate = (this.annualInterestRate / 12);
        double monthlyInterest = this.balance * monthlyInterestRate;
        this.balance = this.balance + monthlyInterest;
        System.out.println("Monthly Interest rate is: " + money.format(monthlyInterestRate));
        System.out.println("Monthly accumulation is: " + money.format(monthlyInterest));
        System.out.println("New Balance is : " + money.format(this.balance));

        return this.balance;

    }

    public double monthlyProcess(double monthlyServiceFees){

        // subtract monthly service fees before calculating interest
        this.balance -= monthlyServiceFees;
        calcInterest();
        this.numOfWithdrawals = 0;
        this.numOfDeposits = 0;
        this.monthlyServiceCharges = 0;

        return this.balance;

    }

    public double getBalance() {
        return balance;
    }

    public int getNumOfDeposits() {
        return numOfDeposits;
    }

    public int getNumOfWithdrawals() {
        return numOfWithdrawals;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getMonthlyServiceCharges() {
        return monthlyServiceCharges;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setNumOfDeposits(int numOfDeposits) {
        this.numOfDeposits = numOfDeposits;
    }

    public void setNumOfWithdrawals(int numOfWithdrawals) {
        this.numOfWithdrawals = numOfWithdrawals;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setMonthlyServiceCharges(int monthlyServiceCharges) {
        this.monthlyServiceCharges = monthlyServiceCharges;
    }
}
