import java.util.ArrayList;

public class User {
    private String userId;
    private String pin;
    private double balance;
    private ArrayList<String> transactionHistory;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: Rs." + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        transactionHistory.add("Withdrew: Rs." + amount);
        return true;
    }

    public boolean transfer(User recipient, double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        recipient.balance += amount;

        transactionHistory.add("Transferred Rs." + amount + " to " + recipient.userId);
        recipient.transactionHistory.add("Received Rs." + amount + " from " + this.userId);
        return true;
    }

    public void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(" " + transaction);
            }
        }
    }
}
