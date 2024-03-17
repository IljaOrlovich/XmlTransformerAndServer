package lt.eif.viko.iorlovic.libraryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a user account entity.
 * @author Ilja
 * @version 1.0
 */
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String userName;
    private String password;

    /**
     * Default constructor for Account.
     * @author Ilja
     * @version 1.0
     */
    public Account() {
    }

    /**
     * Constructs an Account with the specified username and password.
     *
     * @param userName the username of the account
     * @param password the password of the account
     */
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    //Getters and setters
    public int getId() {

        return this.id;
    }
    public void setId(int id) {

        this.id = id;
    }
    public String getUserName() {

        return this.userName;
    }
    public void setUserName(String userName) {

        this.userName = userName;
    }
    public String getPassword() {

        return this.password;
    }
    public void setPassword(String password) {

        this.password = password;
    }

    /**
     * Returns a string representation of the account, including username and password.
     *
     * @return a string representation of the account
     */
    @Override
    public String toString() {
        return String.format("\t\tUserName: %s\n" +
                        "\t\tPassword: %s",
                this.userName, this.password);
    }


}
