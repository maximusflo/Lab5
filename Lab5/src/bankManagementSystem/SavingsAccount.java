package bankManagementSystem;

public class SavingsAccount extends BankAccount{
	
	public SavingsAccount(int accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance, "Savings");
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}
	
	public void withdraw(double amount) {
        if (balance - amount >= 100) {
            balance = balance - amount;
            logTransaction("$" + amount + " withdrawn.");
        } else {
            System.out.println("\nWithdrawal of $" + amount + " failed: Must have minimum balance of $100");
            logTransaction("Withdrawal of $" + amount + " failed: Must have minimum balance of $100");
        }
    }
	
	public void interest() {
		if(balance >= 100) {
			balance = balance + (balance * 0.0041);
			System.out.println("\nInterest Accrued: Balance now $" + balance);
			logTransaction("Interest Accrued: Balance now $" + balance);
		} else {
			System.out.println("\nInsufficient funds!");
		}
	}
}
