package lt.eif.viko.iorlovic.libraryapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents an author entity.
 * @author Ilja
 * @version 1.0
 */
@XmlRootElement
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String firstName;
    private String lastName;

    @OneToOne(targetEntity = Account.class, cascade = CascadeType.ALL)
    private Account account;

    @OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    @OneToMany(targetEntity = Awards.class, cascade = CascadeType.ALL)
    private List<Awards> awards = new ArrayList<>();

    /**
     * Default constructor for Author.
     */
    public Author() {

    }

    /**
     * Constructs an Author with the specified first name and last name.
     *
     * @param firstName the first name of the author
     * @param lastName  the last name of the author
     */
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
    }
    public String getFirstName() {

        return firstName;
    }
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }
    public String getLastName() {

        return lastName;
    }
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }
    public Account getAccount() {

        return account;
    }
    public void setAccount(Account account) {

        this.account = account;
    }
    public List<Book> getBooks() {

        return books;
    }
    public void setBooks(List<Book> books) {

        this.books = books;
    }

    public List<Awards> getAwards() {

        return awards;
    }

    public void setAwards(List<Awards> awards) {

        this.awards = awards;
    }

    /**
     * Returns a string representation of the author, including first name, last name, account, and books.
     *
     * @return a string representation of the author
     */
    @Override
    public String toString() {
        return String.format("Author: " +
                        "\n\tFirst name: %s" +
                        "\n\tLast Name: %s" +
                        "\n\tAwards:  \n%s" +
                        "\n\tAccount: \n%s " +
                        "\n\tBooks:  \n%s",
                this.firstName, this.lastName, this.awards, this.account, this.constructBookList());
    }
    private String constructBookList() {
        String result = "";

        Book book;
        for(Iterator var2 = this.books.iterator(); var2.hasNext(); result = result + book) {
            book = (Book) var2.next();
        }

        return result;
    }
}
