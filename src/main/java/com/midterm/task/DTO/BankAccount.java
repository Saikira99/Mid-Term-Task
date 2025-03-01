package com.midterm.task.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankAccount {
    @Id
    private int accountNumber;
    private String customerName;
    private double actBalance;
    private String city;
    private int branchCode;
    public BankAccount(){

    }



    public BankAccount(int accountNumber, String customerName, double actBalance, String city, int branchCode) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.actBalance = actBalance;
        this.city = city;
        this.branchCode = branchCode;
    }

    public int getActNumber() {
        return accountNumber;
    }

    public void setActNumber(int actNumber) {
        this.accountNumber = actNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getActBalance() {
        return actBalance;
    }

    public void setActBalance(double actBalance) {
        this.actBalance = actBalance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "actNumber=" + accountNumber +
                ", customerName='" + customerName + '\'' +
                ", actBalance=" + actBalance +
                ", city='" + city + '\'' +
                ", branchCode=" + branchCode +
                '}';
    }
}
