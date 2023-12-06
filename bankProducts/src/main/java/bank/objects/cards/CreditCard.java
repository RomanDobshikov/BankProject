package bank.objects.cards;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditCard extends AbstractCard {
    private double debtAmount;
    private double interestRate;

    public CreditCard(double debtAmount, String currency) {
        super(currency);
        this.debtAmount = debtAmount;
    }

    public CreditCard(String currency, double balance, String productName) {
        super(currency, balance, productName);
    }

    public CreditCard(String currency, double balance, String productName, double interestRate) {
        super(currency, balance, productName);
        this.interestRate = interestRate;
    }

    @Override
    public double replenishment(double amountOfMoney) {
        System.out.println("Your balance on " + productName + ": " + balance + " " + currency);
        balance += amountOfMoney;
        System.out.println("Successful replenishment! Your current balance: " + balance + " " + currency);
        return balance;
    }

    @Override
    public double debiting(double amount) {
        balance -= amount;
        System.out.println("Withdrawn " + amount + " from " + productName);
        return balance;
    }

    @Override
    public double getBalance() {
        System.out.println("Your current balance: " + balance + " " + currency + " on " + productName);
        return balance;
    }

    public double makePurchase(double amount) {
        System.out.println("Your balance: " + balance);
        System.out.println("Made a purchase of " + amount + " " + currency + " on " + productName);
        var currentBalance = balance - amount;
        System.out.println("Purchase success, your current balance: " + currentBalance + " " + currency + " on " + productName);
        return currentBalance;
    }

    public double calculateInterest() {
        double interest = balance * interestRate / 100.0;
        System.out.println("Product name: " + productName + "; Interest Rate: " + interestRate);
        System.out.println("Balance: " + balance + " " + currency);
        System.out.println("Calculated interest: " + interest);
        return interest;
    }

    public String requestDebtMessage() {
        String debtMessage;
        if (debtAmount <= 0) {
            debtMessage = "You haven't any debts";
            System.out.println(debtMessage);
        } else {
            debtMessage = "You have a debt";
            System.out.println(debtMessage + " " + debtAmount + " " + currency);
        }
        return debtMessage;
    }
}
