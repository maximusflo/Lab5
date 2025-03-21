package bankManagementSystem;

import java.util.ArrayList;

public abstract class BankAccount {
	protected int accountNumber;
	protected String holderName;
	protected double balance;
	protected String accountType;
	ArrayList<String> logHistory = new ArrayList<>();
	
	public BankAccount(int accountNumber, String holderName, double balance, String accountType) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
		this.accountType = accountType;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
		logTransaction("$" + amount + " deposited.");
	}
	
	public void withdraw(double amount) {
		if (balance >= amount) {
			balance = balance - amount;
			logTransaction("$" + amount + " withdrawn.");
		} else {
			System.out.println("Insufficient funds.");
			logTransaction("$" + amount + " failed to withdraw.");
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String displayAccountInfo() {
		String bankAccount;
		bankAccount = "\nAccount Type: " + accountType + "\nHolder's Name: " + holderName + "\nAccount Number: " + accountNumber + "\nBalance: $" + balance;
		return bankAccount;
	}
	
	public void logTransaction(String message) {
		logHistory.add(message);
	}
}

