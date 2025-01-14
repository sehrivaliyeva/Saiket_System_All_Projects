package all_projects.Basic_Banking_System;

import java.util.Date;

public class Transaction {
    private Date date;
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.date = new Date();
        this.type = type;
        this.amount = amount;
    }

    public String getDetails() {
        return "Date: " + date + ", Type: " + type + ", Amount: " + amount;
    }
}
