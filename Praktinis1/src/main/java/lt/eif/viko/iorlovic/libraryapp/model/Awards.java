package lt.eif.viko.iorlovic.libraryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Awards class represents an award received by an author.
 */
@Entity
@Table(name = "awards")
public class Awards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String title;
    private int years;

    /**
     * Default constructor for Awards.
     * @author Ilja
     * @version 1.0
     */
    public Awards() {
    }

    /**
     * Parameterized constructor for Awards.
     *
     * @param title The title of the award.
     * @param years The year the award was received.
     */
    public Awards(String title, String years) {
        this.title = title;
        this.years = Integer.parseInt(years);
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public int getYears() {

        return years;
    }

    public void setYears(int years) {

        this.years = years;
    }

    @Override
    public String toString() {
        return String.format("\t\tAward: \n" +
                        "\t\t\tName: %s\n " +
                        "\t\t\tYears: %d\n",
                this.title, this.years);
    }
}
