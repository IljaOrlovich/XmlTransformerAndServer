package lt.eif.viko.iorlovic.libraryapp.tests;

import lt.eif.viko.iorlovic.libraryapp.model.Awards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AwardsTest {

    private Awards award;

    @BeforeEach
    public void setUp() {
        award = new Awards("Best Book Award", "2020");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Best Book Award", award.getTitle());
        assertEquals(2020, award.getYears());
    }

    @Test
    public void testToString() {
        String expected = "\t\tAward: \n" +
                "\t\t\tName: Best Book Award\n " +
                "\t\t\tYears: 2020\n";
        assertEquals(expected, award.toString());
    }

    // Add more test cases for other methods if needed
}
