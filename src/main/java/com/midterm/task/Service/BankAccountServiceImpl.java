package com.midterm.task.Service;

import com.midterm.task.DAO.BankAccountDao;
import com.midterm.task.DAO.BankAccountDaoImpl;
import com.midterm.task.DTO.BankAccount;

import java.util.List;

public class BankAccountServiceImpl implements BankAccountService {
    BankAccountDao bankAccountDao =new BankAccountDaoImpl();


    @Override
    public void addAccount(BankAccount bankAccount) {
        bankAccountDao.addAccount(bankAccount);

    }

    @Override
    public void updateAccount(BankAccount bankAccount) {
        bankAccountDao.updateAccount(bankAccount);

    }

    @Override
    public void deleteAccount(int accountNumber) {
        bankAccountDao.deleteAccount(accountNumber);
    }

    @Override
    public void displayAllAccounts() {
        bankAccountDao.displayAllAccounts();
    }

    @Override
    public void displayAccountNameAndNumber() {
    bankAccountDao.displayAccountNameAndNumber();
    }

    @Override
    public BankAccount findBankAccountByAccountNumber(int accountNumber) {
        BankAccount account = findBankAccountByAccountNumber(accountNumber);
        if(account==null) System.out.println("No product found with product id = "+accountNumber);
        return account;
    }

    @Override
    public List<BankAccount> findBankAccountsByCustomerName(String customerName) {
        return bankAccountDao.findBankAccountsByCustomerName(customerName);
    }

    @Override
    public List<BankAccount> findBankAccountsByBranchCode(int branchCode) {
        return bankAccountDao.findBankAccountsByBranchCode(branchCode);
    }

    @Override
    public List<Object[]> findGroupedBankAccounts() {
        return bankAccountDao.findGroupedBankAccounts();
    }
}
