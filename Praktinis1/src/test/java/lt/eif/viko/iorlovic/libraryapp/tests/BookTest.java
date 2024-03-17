package lt.eif.viko.iorlovic.libraryapp.tests;

import lt.eif.viko.iorlovic.libraryapp.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book("Book2", "1925");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Book2", book.getName());
        assertEquals(1925, book.getYears());
    }

    @Test
    public void testToString() {
        String expected = "\t\tBook: \n" +
                "\t\t\tName: Book2\n " +
                "\t\t\tYears: 1925\n";
        assertEquals(expected, book.toString());
    }
}
