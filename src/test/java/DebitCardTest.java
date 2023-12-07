import bank.objects.cards.AbstractCard;
import bank.objects.cards.DebitCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DebitCardTest {

    @Test
    public void depositIncreasesBalanceTest() {
        DebitCard debitCard = new DebitCard("RUB", 1000.0, "Regular Debit Card");
        assertEquals(1500.0, debitCard.replenishment(500.0), 0.01);
        assertEquals(1500.0, debitCard.getBalance(), 0.01);
    }

    @Test
    public void makePurchaseDecreasesBalanceTest() {
        DebitCard debitCard = new DebitCard("RUB", 1000.0, "Regular Debit Card");
        assertEquals(800.0, debitCard.makePurchase(200.0), 0.01);
    }

    @Test
    public void withdrawDecreasesBalanceTest() {
        DebitCard debitCard = new DebitCard("RUB", 1000.0, "Regular Debit Card");
        debitCard.debiting(200.0);
        assertEquals(800.0, debitCard.getBalance(), 0.01);
    }

    @Test
    public void checkCardStatusTest() {
        AbstractCard debitCard = new DebitCard("RUB", 1000.0, "Regular Debit Card");
        assertEquals("You have 1000.0 RUB on your Regular Debit Card", debitCard.checkCardStatus());
    }

    @Test
    public void getBalanceTest() {
        DebitCard creditCard = new DebitCard("RUB", 500.0, "Regular Credit Card");
        assertEquals(500, creditCard.getBalance());
    }
}
