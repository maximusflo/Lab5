package bankManagementSystem;

public class CheckingAccount extends BankAccount {
    
    public CheckingAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance, "Checking");
    }
    
    public void withdraw(double amount) {
        if (balance - amount >= -500.0) {
            balance = balance - amount;
            logTransaction("$" + amount + " withdrawn.");
            
            if (balance < 0) {
                balance = balance - 35.0;
                logTransaction("Overdraft used. Fee of $" + 35.0 + " applied.");
            }
        } else {
            System.out.println("\nInsufficient funds, exceeds overdraft limit.");
            logTransaction("Withdrawal of $" + amount + " failed: Exceeded overdraft limit.");
        }
    }
}
