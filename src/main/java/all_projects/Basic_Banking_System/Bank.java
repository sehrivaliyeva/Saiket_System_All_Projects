package all_projects.Basic_Banking_System;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, new BankAccount(accountNumber));
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account with this number already exists.");
        }
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
