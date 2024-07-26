package com.midterm.task.IO;

import com.midterm.task.DTO.BankAccount;
import com.midterm.task.Service.BankAccountService;
import com.midterm.task.Service.BankAccountServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add a Account");
        System.out.println("2. Delete a Account ");
        System.out.println("3. Update a Account");
        System.out.println("4. Display All Accounts");
        System.out.println("5. Display AccountName and AccountNumber");
        System.out.println("6. Find Bank Accounts by CustomerName");
        System.out.println("7. Find Bank Accounts by BranchCode");
        System.out.println("8. Find Grouped BankAccounts");
        System.out.println("Enter your Choice: ");
        int ch = sc.nextInt();
        switch(ch) {
            case 1:addAccount();
                break;
            case 2:
                deleteAccount();
                break;
            case 3:
               updateAccount();
                break;
            case 4:
                displayAllAccounts();
                break;
            case 5:
                displayAccountNameAndNumber();
                break;
            case 6:
                findBankAccountsByCustomerName();
                break;
            case 7:
                findBankAccountsByBranchCode();
            case 8:
                findGroupedBankAccounts();
            default: System.out.println("Invalid Input!"); break;

        }
    }
    public static void addAccount(){
        BankAccount a1=new BankAccount(111,"Sccot1",2300,"Chennai",12345);
        BankAccount a2=new BankAccount(112,"Sccot1",2300,"Chennai",12345);
        BankAccount a3=new BankAccount(113,"Sccot2",2300,"Chennai",12345);
        BankAccount a4=new BankAccount(114,"Sccot2",2300,"Chennai",12345);
        BankAccount a5=new BankAccount(115,"Sccot3",2300,"Chennai",12345);
        BankAccount a6=new BankAccount(116,"Sccot4",2300,"Hyderabad",123456);
        BankAccount a7=new BankAccount(117,"Sccot4",2300,"Hyderabad",123456);

        BankAccountService service= new BankAccountServiceImpl();
        service.addAccount(a1);
        service.addAccount(a2);
        service.addAccount(a3);
        service.addAccount(a4);
        service.addAccount(a5);
        service.addAccount(a6);
        service.addAccount(a7);
        System.out.println("Account added sucessfully :)");
    }
    public static void updateAccount(){
    BankAccountService service=new BankAccountServiceImpl();
    BankAccount updatedBankAccount =new BankAccount(116,"Sai",50009,"Chennai",12345);
    service.updateAccount(updatedBankAccount);
        System.out.println("Updated Sucessfully :)");
    }
    public static void deleteAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Product Id to delete: ");
        int productId = sc.nextInt();
        BankAccountService service=new BankAccountServiceImpl();
        service.deleteAccount(productId);
    }
    public static void displayAllAccounts(){
        BankAccountService service=new BankAccountServiceImpl();
        service.displayAllAccounts();
    }
    public static void displayAccountNameAndNumber(){
        BankAccountService service=new BankAccountServiceImpl();
        service.displayAccountNameAndNumber();
    }

    public static void findBankAccountsByCustomerName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer Name to find: ");
        String customerName = sc.nextLine();
        BankAccountService service = new BankAccountServiceImpl();
        List<BankAccount> accounts = service.findBankAccountsByCustomerName(customerName);
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }
    public static void findBankAccountsByBranchCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Branch Code to find: ");
        int branchCode = sc.nextInt();
        BankAccountService service = new BankAccountServiceImpl();
        List<BankAccount> accounts = service.findBankAccountsByBranchCode(branchCode);
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }
    public static void findGroupedBankAccounts() {
        BankAccountService service = new BankAccountServiceImpl();
        List<Object[]> groupedAccounts = service.findGroupedBankAccounts();
        for (Object[] group : groupedAccounts) {
            System.out.println("Account Number:"+group[0]+", Customer Name: " + group[1] + ", City: " + group[2]);
        }
    }

}
