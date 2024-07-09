package com.kce.bank.service;

import com.kce.bank.bean.Account;
import com.kce.bank.bean.Transaction;
import com.kce.bank.dao.AccountDAO;
import com.kce.bank.dao.TransactionDAO;

public class BankingService {
	private AccountDAO accountDAO;
    private TransactionDAO transactionDAO;

    public BankingService() {
        accountDAO = new AccountDAO();
        transactionDAO = new TransactionDAO();
    }

    public void deposit(int accountId, double amount) {
        Account account = accountDAO.getAccount(accountId);
        if (account != null) {
            double newBalance = account.getBalance() + amount;
            accountDAO.updateBalance(accountId, newBalance);
            Transaction transaction = new Transaction(accountId, "DEPOSIT", amount);
            transactionDAO.addTransaction(transaction);
        }
    }

    public void withdraw(int accountId, double amount) {
        Account account = accountDAO.getAccount(accountId);
        if (account != null) {
            double newBalance = account.getBalance() - amount;
            if (newBalance >= 0) {
                accountDAO.updateBalance(accountId, newBalance);
                Transaction transaction = new Transaction(accountId, "WITHDRAW", amount);
                transactionDAO.addTransaction(transaction);
            } else {
                System.out.println("Insufficient funds.");
            }
        }
    }
}
