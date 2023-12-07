import bank.objects.accounts.Deposit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositTest {

    @Test
    public void depositReplenishmentTest() {
        Deposit deposit = new Deposit("RUB", 1000.0, "Regular Deposit");
        assertEquals(1300.0, deposit.depositReplenishment(300.0));
    }

    @Test
    public void checkYourBalance() {
        Deposit deposit = new Deposit("RUB", 1000.0, "Regular Deposit");
        assertEquals(1000.0, deposit.checkYourBalance());
    }

    @Test
    public void closeAccountWithMoneyTest() {
        Deposit deposit = new Deposit("RUB", 1000.0, "Regular Deposit");
        assertEquals("You need to withdraw all the money before closing Regular Deposit; You have 1000.0 RUB",
            deposit.closeAccount());
    }

    @Test
    public void closeAccountWithoutMoneyTest() {
        Deposit deposit = new Deposit("RUB", 0, "Regular Deposit");
        assertEquals("Closed Regular Deposit account.", deposit.closeAccount());
    }

    @Test
    public void closeAccountWithNegativeBalanceTest() {
        Deposit deposit = new Deposit("RUB", -1000.0, "Regular Deposit");
        assertEquals("ERROR; Negative balance", deposit.closeAccount());
    }

    @Test
    public void requestInterestRateTest() {
        Deposit deposit = new Deposit(10, "Regular Deposit");
        assertEquals(10, deposit.requestInterestRate());
    }

    @Test
    public void getDepositInBankTest() {
        Deposit deposit = new Deposit("RUB", 1000.0, "Regular Deposit", 10);
        assertEquals(1100.0, deposit.getDepositForAYear());
    }
}
