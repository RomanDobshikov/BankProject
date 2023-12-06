package bank.objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class BankProduct {
    protected String currency;
    protected double balance;
    protected String productName;

    public BankProduct(String currency, double balance, String productName) {
        this.currency = currency;
        this.balance = balance;
        this.productName = productName;
    }

    public BankProduct(String value) {
        this.currency = value;
        this.productName = value;
    }
}
