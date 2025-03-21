package bankManagementSystem;

import java.util.ArrayList;

public class Bank {
	ArrayList<BankAccount> accounts = new ArrayList<>();
	
	public void createAccount(BankAccount bankAccount) {
		accounts.add(bankAccount);
	}
	
	public void deposit(int accountNumber, double amount) {
		for (BankAccount bankAccount: accounts) {
			if (bankAccount.accountNumber == accountNumber) {
				bankAccount.deposit(amount);
				System.out.println("\n$" + amount + " deposited successfully.");
			} 
			if (bankAccount.accountNumber != accountNumber) {
				System.out.println("\nAccount not found.");
			}
		}
	}
	
	public void withdraw(int accountNumber, double amount) {
		for (BankAccount bankAccount: accounts) {
			if (bankAccount.accountNumber == accountNumber) {
				bankAccount.withdraw(amount);
				System.out.println("\n$" + amount + " withdrawn successfully.");
			} 
			if (bankAccount.accountNumber != accountNumber) {
				System.out.println("\nAccount not found.");
			}
		}
	}
	
	public void transferFunds(int fromAccount, int toAccount, double amount) {
		BankAccount from = null;
		BankAccount to = null;
		for (BankAccount account : accounts) {
		    if (account.accountNumber == fromAccount) {
		        from = account;
		    }
		    if (account.accountNumber == toAccount) {
		        to = account;
		    }
		}
		    
		if (from != null && to != null) {
		    if (from.getBalance() >= amount) {
		        from.withdraw(amount);
		        to.deposit(amount);
		        System.out.println("\n$" + amount + " transferred successfully.");
		    } else {
		        System.out.println("\nInsufficient funds.");
		    }
	    } else {
		    System.out.println("\nInvalid account number(s).");
	    }
	}
	
	public void viewTransactionHistory(int accountNumber) {
		for (BankAccount bankAccount: accounts) {
			if (bankAccount.accountNumber == accountNumber) {
				System.out.println("\nTransaction History:");
				for (String message: bankAccount.logHistory) {
					System.out.println(message);
				}
			}
		}
	}
	
	public void displayAllAccounts() {
		for (BankAccount bankAccount: accounts) {
			System.out.println(bankAccount.displayAccountInfo());
		}
	}
}
