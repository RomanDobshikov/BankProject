package bank.objects.cards;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class DebitCard extends AbstractCard {

    public DebitCard(String currency, double balance, String productName) {
        super(currency, balance, productName);
    }

    public DebitCard(String currency) {
        super(currency);
    }

    @Override
    public double replenishment(double amountOfMoney) {
        System.out.println("Your balance on " + productName + ": " + balance + " " + currency);
        var newBalance = balance += amountOfMoney;
        System.out.println("Successful replenishment! Your current balance: " + newBalance + " " + currency);
        return newBalance;
    }

    @Override
    public double debiting(double amount) {
        balance -= amount;
        System.out.println("Withdrawn " + amount + " " + currency + " from " + productName);
        return balance;
    }

    @Override
    public double getBalance() {
        System.out.println("Your balance: " + balance + " " + currency);
        return balance;
    }

    public double makePurchase(double amount) {
        System.out.println("Made a purchase of " + amount + " using " + productName);
        var currentBalance = balance - amount;
        System.out.println("Purchase success, your current balance: " + currentBalance + " " + currency);
        return currentBalance;
    }
}
