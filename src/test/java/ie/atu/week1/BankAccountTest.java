package ie.atu.week1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setup()
    {
        account = new BankAccount();
    }

    @Test
    void constructorInitialisation(){
        account=new BankAccount("ACC12345", "Nandita",100);
        assertEquals("ACC12345",account.getAccno());
        assertEquals("Nandita",account.getName());
        assertEquals(100, account.getBalance());
    }

    @Test
    void constructorNegativeInitialisation(){
        Exception ex= assertThrows(IllegalArgumentException.class,()-> new BankAccount("Acc12345", "Nandita", -100));
        assertEquals("Balance must be greater than 0", ex.getMessage( ));
    }
    @Test
    void depositPositiveIncreasesBalance() {
        account = new BankAccount("ACC12345", "Nandita", 100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void depositZeroOrNegativeThrowsException() {
        account = new BankAccount("ACC12345", "Nandita", 100);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertEquals("Deposit amount must be positive", ex.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> account.deposit(-10));//put both zero and negative number in one place
        assertEquals("Deposit amount must be positive", ex2.getMessage());
    }

        @Test
        void withdrawPositiveReducesBalance() {
            account = new BankAccount("ACC12345", "Nandita", 100);
            account.withdraw(40);
            assertEquals(60, account.getBalance());
        }

        @Test
        void withdrawZeroOrNegativeThrowsException() {
            account = new BankAccount("ACC12345", "Nandita", 100);

            Exception ex = assertThrows(IllegalArgumentException.class,
                    () -> account.withdraw(0));
            assertEquals("Withdraw amount must be positive", ex.getMessage());

            Exception ex2 = assertThrows(IllegalArgumentException.class,
                    () -> account.withdraw(-20));
            assertEquals("Withdraw amount must be positive", ex2.getMessage());
        }

        @Test
        void withdrawMoreThanBalanceThrowsCustomException() {
            account = new BankAccount("ACC12345", "Nandita", 100);

            Exception ex = assertThrows(IllegalArgumentException.class,
                    () -> account.withdraw(200));
            assertEquals("Insufficient funds", ex.getMessage());
        }
    }

}
