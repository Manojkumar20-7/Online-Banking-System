package com.kce.bank.bean;

public class Account {
	private int id;
    private int customerId;
    private String accountType;
    private double balance;
    
	public Account() {
		super();
	}

	public Account(int id, int customerId, String accountType, double balance) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.accountType = accountType;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
    	
}
