package bankManagementSystem;

import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bank bank = new Bank();
		Random random = new Random();
		int choice;
		
		System.out.println("Welcome to the Bank");
		
		do {
			System.out.println("\n	1. Create Account");
			System.out.println("	2. Deposit Money");
			System.out.println("	3. Withdraw Money");
			System.out.println("	4. Transfer Funds");
			System.out.println("	5. Display Account Details");
			System.out.println("	6. View Transaction History");
			System.out.println("	7. Calculate Interest");
			System.out.println("	8. Exit Program");
			System.out.print("\nEnter choice: ");
			
			while (!scanner.hasNextInt()) {
				System.out.print("\nError, please enter valid choice: ");
				scanner.nextLine();
			}
		
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
				case 1:
					System.out.print("\nWould you like to create a Savings(1) or Checking(2) account? \nEnter 1 or 2: ");
					int accountType = scanner.nextInt();
					scanner.nextLine();
					System.out.print("\nEnter name of account: ");
					String name = scanner.nextLine();
					System.out.print("\nEnter amount to deposit: ");
					double initialBalance = scanner.nextDouble();
					
					if (accountType == 1) {
						if (initialBalance < 100) {
							System.out.println("\nInsuficent funds to create savings account.");
						} else {
							int accountNum = random.nextInt(10000000);
							bank.createAccount(new SavingsAccount(accountNum, name, initialBalance));
							System.out.println("\nSavings Account created successfully. \nAccount number: " + accountNum);
						}
					} else {
						int accountNum = random.nextInt(10000000);
						bank.createAccount(new CheckingAccount(accountNum, name, initialBalance));
						System.out.println("\nChecking Account created successfully. \nAccount number: " + accountNum);
					}
					break;
					
				case 2:
					if (bank.accounts.isEmpty()) {
						System.out.println("\nNo accounts available to deposit to.");
						break;
					}
					System.out.print("\nEnter account number: ");
					int depositNum = scanner.nextInt();
					scanner.nextLine();
					System.out.print("\nEnter amount to deposit: ");
					double depositAmount = scanner.nextDouble();
					bank.deposit(depositNum, depositAmount);
					break;
					
				case 3:
					if (bank.accounts.isEmpty()) {
						System.out.println("\nNo accounts available to withdraw from.");
						break;
					}
					System.out.print("\nEnter account number: ");
					int withdrawNum = scanner.nextInt();
					System.out.print("\nEnter amount to withdraw: ");
					double withdrawAmount = scanner.nextDouble();
					bank.withdraw(withdrawNum, withdrawAmount);
					break;
					
				case 4:
					if (bank.accounts.isEmpty()) {
						System.out.println("\nNo accounts available to transfer funds.");
						break;
					}
					System.out.print("\nEnter account number to transfer funds from: ");
					int fromAccount = scanner.nextInt();
					System.out.print("\nEnter account number to transfer funds to: ");
					int toAccount = scanner.nextInt();
					System.out.print("\nEnter amount to transfer: ");
					double transferAmount = scanner.nextDouble();
					bank.transferFunds(fromAccount, toAccount, transferAmount);
					break;
					
				case 5:
					if (bank.accounts.isEmpty()) {
						System.out.println("\nNo accounts available to display.");
						break;
					}
					bank.displayAllAccounts();
					break;
					
				case 6:
					if (bank.accounts.isEmpty()) {
						System.out.println("\nNo accounts available to view transaction history.");
						break;
					}
					System.out.print("\nEnter account number: ");
					int accNum = scanner.nextInt();
					scanner.nextLine();
					bank.viewTransactionHistory(accNum);
					break;
					
				case 7:
					if (bank.accounts.isEmpty()) {
						System.out.println("\nNo accounts available to calculate interest.");
						break;
					}
					System.out.print("\nEnter account number: ");
					int interestNum = scanner.nextInt();
					scanner.nextLine();
					for (BankAccount account : bank.accounts) {
				        if (account.accountNumber == interestNum && account instanceof SavingsAccount) {
				            ((SavingsAccount) account).interest();
				            break;
				        } else if (account.accountNumber == interestNum) {
				            System.out.println("\nInterest is only available for savings accounts.");
				            break;
				        }
				    }
					break;
					
				case 8:
					System.out.println("\nExiting the program...");
					break;
					
				default:
					System.out.print("\nError, please enter a valid choice. \n");
			}
		} while (choice != 8);
		
		scanner.close();
	}

}
