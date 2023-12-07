package bank.objects.cards;

import bank.objects.BankProduct;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class AbstractCard extends BankProduct {

    public AbstractCard(String currency, double balance, String productName) {
        super(currency, balance, productName);
    }

    public AbstractCard(String currency) {
        super(currency);
    }

    public abstract double replenishment(double amount);

    public abstract double debiting(double amount);

    public abstract double getBalance();

    public String checkCardStatus() {
        String info = "You have " + balance + " " + currency + " on your " + productName;
        System.out.println(info);
        return info;
    }
}
