import bank.objects.cards.CreditCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardTest {

    @Test
    public void calculateInterestTest() {
        CreditCard creditCard = new CreditCard("RUB", 1000.0, "Regular Credit Card", 10.0);
        assertEquals(100.0, creditCard.calculateInterest(), 0.01);
    }

    @Test
    public void requestWithoutDebtAndCurrencyTest() {
        CreditCard creditCard = new CreditCard(0, "RUB");
        assertEquals("You haven't any debts", creditCard.requestDebtMessage());
    }

    @Test
    public void requestWithDebtAndCurrencyTest() {
        CreditCard creditCard = new CreditCard(500, "RUB");
        assertEquals("You have a debt", creditCard.requestDebtMessage());
    }

    @Test
    public void makePurchaseTest() {
        CreditCard creditCard = new CreditCard("RUB", 500.0, "Regular Credit Card");
        assertEquals(450, creditCard.makePurchase(50));
    }

    @Test
    public void getBalanceTest() {
        CreditCard creditCard = new CreditCard("RUB", 500.0, "Regular Credit Card");
        assertEquals(500, creditCard.getBalance());
    }
}
