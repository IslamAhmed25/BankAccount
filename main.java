
import java.util.Scanner;

class BankAccount {
    private double balance;
    private int totalTransactions;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.totalTransactions = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            totalTransactions++;
            System.out.println("Deposit successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } 
        else if (amount > balance) {
            System.out.println("Error: Insufficient balance.");
        } 
        else {
            balance -= amount;
            totalTransactions++;
            System.out.println("Withdraw successful. Current balance: " + balance);
        }
    }
    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    public void showSummary() {
        System.out.println("Total transactions performed: " + totalTransactions);
        System.out.println("Final balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BankAccount account = new BankAccount(700.0);

        int choice;

        while (true) {
            System.out.println("\n----- Bank Account Simulator -----");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    account.showSummary();
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
