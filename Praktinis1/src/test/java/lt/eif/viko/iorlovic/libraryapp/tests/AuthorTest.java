package lt.eif.viko.iorlovic.libraryapp.tests;

import lt.eif.viko.iorlovic.libraryapp.model.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthorTest {

    private Author author;

    @BeforeEach
    public void setUp() {
        author = new Author("John", "Doe");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("John", author.getFirstName());
        assertEquals("Doe", author.getLastName());
        assertNotNull(author.getBooks());
        assertNotNull(author.getAwards());
    }

    @Test
    public void testToString() {
        String expected = "Author: \n\tFirst name: John\n\tLast Name: Doe\n\tAwards:  \n[]\n\tAccount: \nnull \n\tBooks:  \n";
        assertEquals(expected, author.toString());
    }
}
