package lt.eif.viko.iorlovic.libraryapp.tests;

import lt.eif.viko.iorlovic.libraryapp.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account("testuser", "testpassword");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("testuser", account.getUserName());
        assertEquals("testpassword", account.getPassword());
    }

    @Test
    public void testToString() {
        String expected = "\t\tUserName: testuser\n\t\tPassword: testpassword";
        assertEquals(expected, account.toString());
    }
}
