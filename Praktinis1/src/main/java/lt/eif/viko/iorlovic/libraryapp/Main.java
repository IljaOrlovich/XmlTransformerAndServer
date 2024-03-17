package lt.eif.viko.iorlovic.libraryapp;

import lt.eif.viko.iorlovic.libraryapp.db.DbLoader;
import lt.eif.viko.iorlovic.libraryapp.menu.Menu;

/**
 * Main class contains the entry point of the library application.
 * @author Ilja
 * @version 1.0
 */
public class Main {
    /**
     * Main method, the entry point of the library application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Menu.showMenu();
        new DbLoader();
    }

}
