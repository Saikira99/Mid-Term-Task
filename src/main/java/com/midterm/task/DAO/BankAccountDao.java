package com.midterm.task.DAO;

import com.midterm.task.DTO.BankAccount;

import java.util.List;

public interface BankAccountDao {
    public void addAccount(BankAccount bankAccount);
    public void updateAccount(BankAccount bankAccount);
    public void deleteAccount (int accountNumber);
    public void displayAllAccounts();
    public void displayAccountNameAndNumber();
    public BankAccount findBankAccountByAccountNumber(int accountNumber);
    public List<BankAccount> findBankAccountsByCustomerName(String customerName);
    public List<BankAccount> findBankAccountsByBranchCode(int branchCode);
    public List<Object[]> findGroupedBankAccounts();


}
