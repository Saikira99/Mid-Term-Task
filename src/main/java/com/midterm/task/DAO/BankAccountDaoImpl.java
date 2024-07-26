package com.midterm.task.DAO;

import com.midterm.task.DTO.BankAccount;
import com.midterm.task.Util.BankAccountUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class BankAccountDaoImpl implements BankAccountDao {

    @Override
    public void addAccount(BankAccount bankAccount) {
        EntityManager em= BankAccountUtil.getEntityManager();
        EntityTransaction et= em.getTransaction();
        et.begin();
        em.persist(bankAccount);
        et.commit();
    }

    @Override
    public void updateAccount(BankAccount bankAccount) {
        EntityManager em = BankAccountUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(bankAccount);
        et.commit();

    }

    @Override
    public void deleteAccount(int accountNumber) {
        EntityManager em = BankAccountUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        BankAccount temp = em.find(BankAccount.class, accountNumber);
        em.remove(temp);
        et.commit();
    }

    @Override
    public void displayAllAccounts() {
        EntityManager em = BankAccountUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        Query query = null;
        et.begin();
        query = em.createQuery("Select account from BankAccount as account");
        List<BankAccount> list = query.getResultList();
        for(BankAccount account: list)
        {
            System.out.println(account);
        }
        et.commit();

    }

    @Override
    public void displayAccountNameAndNumber() {
        EntityManager em = BankAccountUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        Query query = null;
        et.begin();
        query = em.createQuery("SELECT account.accountNumber,account.customerName FROM BankAccount as account");
        List<Object[]> listAccountnumberAndcustomerName = query.getResultList();
        for(Object[] o : listAccountnumberAndcustomerName)
        {
            System.out.println(o[0]+" "+o[1]);
        }
        et.commit();
    }

    @Override
    public BankAccount findBankAccountByAccountNumber(int accountNumber) {
        EntityManager em = BankAccountUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        BankAccount temp = em.find(BankAccount.class, accountNumber);
        et.commit();
        if(temp==null) System.out.println("Failed to find the account "+accountNumber);
        return temp;
    }

    @Override
    public List<BankAccount> findBankAccountsByCustomerName(String customerName) {
        EntityManager em = BankAccountUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Query query = em.createQuery("SELECT account FROM BankAccount account WHERE account.customerName = :customerName");
        query.setParameter("customerName", customerName);
        List<BankAccount> accounts = query.getResultList();
        et.commit();
        return accounts;
    }

    @Override
    public List<BankAccount> findBankAccountsByBranchCode(int branchCode) {
        EntityManager em = BankAccountUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Query query = em.createQuery("SELECT account FROM BankAccount account WHERE account.branchCode = :branchCode");
        query.setParameter("branchCode", branchCode);
        List<BankAccount> accounts = query.getResultList();
        et.commit();
        return accounts;
    }

    @Override
    public List<Object[]> findGroupedBankAccounts() {
        EntityManager em = BankAccountUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Query query = em.createQuery("SELECT account.accountNumber, account.customerName, account.city FROM BankAccount account GROUP BY account.accountNumber, account.customerName, account.city");
        List<Object[]> groupedAccounts = query.getResultList();
        et.commit();
        return groupedAccounts;
    }
}
