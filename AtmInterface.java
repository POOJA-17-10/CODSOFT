//ATM.java

  public class ATM {
    private BankAccount bankAccount;
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void performTransaction(int choice, double amount) {
        switch (choice) {
            case 1:
                System.out.println("Current Balance: " + bankAccount.getBalance());
                break;
            case 2:
                bankAccount.deposit(amount);
                System.out.println("Deposit successful. New balance: " + bankAccount.getBalance());
                break;
            case 3:
                if (bankAccount.withdraw(amount)) {
                    System.out.println("Withdrawal successful. New balance: " + bankAccount.getBalance());
                }
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }
}

//BankAccount.java
public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
            return false;
        }
    }
}

//Main.java

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            if (choice == 4) {
                break;
            }
            System.out.print("Enter transaction amount: ");
            double amount = scanner.nextDouble();
            atm.performTransaction(choice, amount);
        }
        scanner.close();
    }
}
