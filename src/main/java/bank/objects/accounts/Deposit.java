package bank.objects.accounts;

import bank.objects.BankProduct;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Deposit extends BankProduct {
    private double interestRate;

    public Deposit(double interestRate, String productName) {
        super(productName);
        this.interestRate = interestRate;
    }

    public Deposit(String currency, double balance, String productName) {
        super(currency, balance, productName);
    }

    public Deposit(String currency, double balance, String productName, double interestRate) {
        super(currency, balance, productName);
        this.interestRate = interestRate;
    }

    public double depositReplenishment(double amountOfMoney) {
        System.out.println("Your balance on " + productName + ": " + balance + " " + currency);
        var newBalance = balance += amountOfMoney;
        System.out.println("Successful replenishment! Your current balance: " + newBalance + " " + currency);
        return newBalance;
    }

    public double checkYourBalance() {
        System.out.println("Your current balance on " + productName + ": " + balance + " " + currency);
        return balance;
    }

    public String closeAccount() {
        String response;
        if (balance > 0) response = "You need to withdraw all the money before closing " + productName
            + "; You have " + balance + " " + currency;
        else if (balance == 0) response = "Closed " + productName + " account.";
        else response = "ERROR; Negative balance";
        System.out.println(response);
        return response;
    }

    public double requestInterestRate() {
        System.out.println("Requested interest rate for " + productName);
        System.out.println("Interest rate: " + interestRate + "%");
        return interestRate;
    }

    public double getDepositForAYear() {
        double rate = 1 + interestRate / 100.0;
        System.out.println("You deposit " + balance + " " + currency + " in the bank on " + productName
            + " with an interest rate " + interestRate + "%");
        balance *= rate;
        return balance;
    }
}
