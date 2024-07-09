package com.kce.bank.bean;

import java.security.Timestamp;

public class Transaction {
	private int id;
    private int accountId;
    private String transactionType;
    private double amount;
    private Timestamp transactionDate;
    
    public Transaction(int accountId, String transactionType, double amount) {
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}
    
}
