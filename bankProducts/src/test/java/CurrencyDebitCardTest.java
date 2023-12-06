import bank.objects.cards.CurrencyDebitCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyDebitCardTest {

    @Test
    public void convertCurrencyTest() {
        CurrencyDebitCard currencyDebitCard = new CurrencyDebitCard("USD", 1000.0, "Currency Debit Card");
        assertEquals(90000.0, currencyDebitCard.convertCurrency(90.0), 0.01);
    }

    @Test
    public void requestExchangeRateTest() {
        CurrencyDebitCard currencyDebitCard = new CurrencyDebitCard("USD", 90.0);
        assertEquals(90.0, currencyDebitCard.requestExchangeRate());
    }

    @Test
    public void withdrawDecreasesBalanceTest() {
        CurrencyDebitCard debitCard = new CurrencyDebitCard("RUB", 1000.0, "Regular Debit Card");
        assertEquals(800.0, debitCard.debiting(200.0), 0.01);
        assertEquals(800.0, debitCard.getBalance(), 0.01);
    }
}
