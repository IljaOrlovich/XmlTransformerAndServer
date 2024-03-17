package lt.eif.viko.iorlovic.libraryapp.jaxb;

import lt.eif.viko.iorlovic.libraryapp.model.Author;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * AuthorListWrapper class represents a wrapper for a list of authors to be used with JAXB.
 * @author Ilja
 * @version 1.0
 */
@XmlRootElement(name = "authors")
public class AuthorListWrapper {

    private List<Author> authors;

    @XmlElement(name = "author")
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
