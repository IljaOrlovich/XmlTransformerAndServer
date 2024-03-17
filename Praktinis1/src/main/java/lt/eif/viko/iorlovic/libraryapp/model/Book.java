package lt.eif.viko.iorlovic.libraryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a book entity.
 * @author Ilja
 * @version 1.0
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private int years;

    /**
     * Default constructor for Book.
     */
    public Book() {
    }

    /**
     * Constructs a Book with the specified name and years.
     *
     * @param name  the name of the book
     * @param years the publication year of the book
     */
    public Book(String name, String years) {
        this.name = name;
        this.years = Integer.parseInt(years);
    }
    //Getters and setters
    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public int getYears() {

        return years;
    }
    public void setYears(int years) {

        this.years = years;
    }

    /**
     * Returns a string representation of the book, including its name and publication year.
     *
     * @return a string representation of the book
     */
    @Override
    public String toString() {
        return String.format("\t\tBook: \n" +
                        "\t\t\tName: %s\n " +
                        "\t\t\tYears: %d\n",
                this.name, this.years);
    }
}
