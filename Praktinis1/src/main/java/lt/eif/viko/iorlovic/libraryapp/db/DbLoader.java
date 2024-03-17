package lt.eif.viko.iorlovic.libraryapp.db;

import lt.eif.viko.iorlovic.libraryapp.HibernateUtil;
import lt.eif.viko.iorlovic.libraryapp.model.Account;
import lt.eif.viko.iorlovic.libraryapp.model.Author;
import lt.eif.viko.iorlovic.libraryapp.model.Awards;
import lt.eif.viko.iorlovic.libraryapp.model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * DbLoader class provides methods for loading data from the database.
 * @author Ilja
 * @version 1.0
 */
public class DbLoader {

    /**
     * Loads authors from the database.
     *
     * @return A list of authors loaded from the database.
     */
    public static List<Author> loadAuthors() {
        List<Author> authors = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                authors = session.createQuery("from Author", Author.class).list();
                for (Author author : authors) {
                    System.out.println(author);
                    for (Book book : author.getBooks()) {
                        System.out.println(" - " + book);
                    }
                }
            } catch (Throwable var4) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var3) {
                        var4.addSuppressed(var3);
                    }
                }
                throw var4;
            }
            if (session != null) {
                session.close();
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }
        return authors;
    }

    /*static {
        Author author2 = new Author("Name2", "LastName2");
        Account account2 = new Account("Username2", "Password2");
        Book book1 = new Book("Book1", "2005");
        Book book2 = new Book("Book2", "2006");
        Awards awards1 = new Awards("Award1", "2008");
        Awards awards2 = new Awards("Award2", "2010");
        author2.getBooks().add(book1);
        author2.getBooks().add(book2);
        author2.setAccount(account2);
        author2.getAwards().add(awards1);
        author2.getAwards().add(awards2);
        System.out.println(author2);
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                transaction = session.beginTransaction();
                session.save(author2);
                transaction.commit();
            } catch (Throwable var15) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var14) {
                        var15.addSuppressed(var14);
                    }
                }

                throw var15;
            }

            if (session != null) {
                session.close();
            }
        } catch (Exception var16) {
            if (transaction != null) {
                transaction.rollback();
            }

            var16.printStackTrace();
        }
    }*/
}
