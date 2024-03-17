package lt.eif.viko.iorlovic.libraryapp.menu;

import lt.eif.viko.iorlovic.libraryapp.JavaServer.JavaServer;
import lt.eif.viko.iorlovic.libraryapp.db.DbLoader;
import lt.eif.viko.iorlovic.libraryapp.jaxb.JaxbUtil;
import lt.eif.viko.iorlovic.libraryapp.model.Author;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Scanner;

/**
 * Menu class represents the menu of the library application.
 * @author Ilja
 * @version 1.0
 */
public class Menu {

    /**
     * Displays the menu options.
     *
     * @param input The Scanner object for user input.
     * @return The user's choice.
     */
    public static int displayMenu(Scanner input) {
        System.out.println(" Make a selection ");
        System.out.println("-------------------");
        System.out.printf("| 1) %20s \n", "Load authors");
        System.out.printf("| 2) %20s \n", "Transform to XML");
        System.out.printf("| 3) %20s \n", "Transform to POJO");
        System.out.printf("| 4) %20s \n", "Send XML to the client");
        System.out.printf("| 6 ) %20s \n", "Quit");
        return input.nextInt();
    }

    /**
     * Displays the main menu and executes selected actions based on user input.
     */
    public static void showMenu() {
        Scanner input = new Scanner(System.in);
        int userChoice;

        do {
            userChoice = displayMenu(input);
            switch (userChoice) {
                case 1:
                    DbLoader.loadAuthors();
                    break;
                case 2:
                    try {
                        List<Author> authors = DbLoader.loadAuthors();
                        JaxbUtil.transformToXML(authors);
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        List<Author> authors = JaxbUtil.transformToPOJO("Author.xml");
                        for (Author author : authors) {
                            System.out.println(author);
                        }
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    Thread serverThread = new Thread(() -> {
                        JavaServer server = new JavaServer();
                        server.start(7777);
                    });
                    serverThread.start();
                    try {
                        serverThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Server has completed its task and stopped.");
                    break;


                case 6:
                    System.out.println("Bye");
                    System.exit(0);
                    break;
            }
        } while(userChoice != 6);
    }
}
