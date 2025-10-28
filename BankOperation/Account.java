import java.util.ArrayList;

class Account {
    String username;
    String password;
    String holderName;
    double balance;
    ArrayList<String> history = new ArrayList<>();

    Account(String username, String password, String holderName) {
        this.username = username;
        this.password = password;
        this.holderName = holderName;
        history.add("Account created with balance: " + balance);
    }

    boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add("Deposited: " + amount);
            System.out.println("Deposited " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            history.add("Withdrew: " + amount);
            System.out.println("Withdrew " + amount);
        } else if (amount > balance) {
            System.out.println("Not enough balance!");
        } else {
            System.out.println("Invalid amount!");
        }
        System.out.println("Available Balance " + balance);
    }

    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    void showTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        for (String h : history) {
            System.out.println(h);
        }
    }
}