package all_projects.Basic_Banking_System;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("Welcome to the Bank System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter account number to create: ");
                String accountNumber = scanner.nextLine();
                bank.createAccount(accountNumber);
            } else if (choice == 2) {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.nextLine();
                BankAccount account = bank.getAccount(accountNumber);
                if (account != null) {
                    System.out.print("Enter deposit amount: ");
                    double amount = scanner.nextDouble();
                    try {
                        account.deposit(amount);
                        System.out.println("Deposit successful.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.nextLine();
                BankAccount account = bank.getAccount(accountNumber);
                if (account != null) {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = scanner.nextDouble();
                    try {
                        account.withdraw(amount);
                        System.out.println("Withdrawal successful.");
                    } catch (IllegalArgumentException | IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 4) {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.nextLine();
                BankAccount account = bank.getAccount(accountNumber);
                if (account != null) {
                    System.out.println("Balance: " + account.getBalance());
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 5) {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.nextLine();
                BankAccount account = bank.getAccount(accountNumber);
                if (account != null) {
                    account.viewTransactions();
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 6) {
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}

