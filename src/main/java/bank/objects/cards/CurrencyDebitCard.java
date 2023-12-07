package bank.objects.cards;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CurrencyDebitCard extends DebitCard {
    private double exchangeRate;

    public CurrencyDebitCard(String currency, double exchangeRate) {
        super(currency);
        this.exchangeRate = exchangeRate;
    }

    public CurrencyDebitCard(String currency, double balance, String productName) {
        super(currency, balance, productName);
    }

    public double convertCurrency(double exchangeRate) {
        double convertedBalance = balance * exchangeRate;
        System.out.println("Converted balance to local currency using exchange rate " + exchangeRate
            + ". Equivalent in local currency: " + convertedBalance + " RUB");
        return convertedBalance;
    }

    public double requestExchangeRate() {
        System.out.println("Requested the current exchange rate for " + currency +
            ". Exchange rate: " + exchangeRate);
        return exchangeRate;
    }
}
