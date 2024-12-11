package ex1;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance > 0.0) {
            this.balance = initialBalance;
        }
        System.out.printf("Initial Balance: %s%n", this.balance); //  balance inicial
    }

    public synchronized void deposit(double amount) {
        if (amount > 0.0) {
            balance += amount;
            System.out.printf("Deposited: %s; Balance: %s%n", amount, balance);
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0.0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrew: %s; Balance: %s%n", amount, balance);
        } else {
            System.out.printf("Withdrawal of %s failed; Balance: %s%n", amount, balance);
            if (amount > balance) {
                System.out.println("Error: Insufficient funds. No money in the account.");
            }
        }
    }

    public double getBalance() {
        return balance;
    }
}


