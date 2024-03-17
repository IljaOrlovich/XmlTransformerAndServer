package lt.eif.viko.iorlovic.libraryapp.jaxb;

import lt.eif.viko.iorlovic.libraryapp.model.Author;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * JaxbUtil class provides methods for transforming data between XML and POJO using JAXB.
 * @author Ilja
 * @version 1.0
 */
public class JaxbUtil {
    /**
     * Transforms a list of authors to XML format and saves it to a file.
     *
     * @param authors The list of authors to be transformed.
     * @throws JAXBException If a JAXB error occurs during transformation.
     */
    public static void transformToXML(List<Author> authors) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(AuthorListWrapper.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        for (Author author : authors) {
            author.getBooks().size();
        }

        AuthorListWrapper wrapper = new AuthorListWrapper();
        wrapper.setAuthors(authors);

        marshaller.marshal(wrapper, new File("Author.xml"));
        marshaller.marshal(wrapper, System.out);
    }

    /**
     * Transforms XML data to a list of authors (POJOs).
     *
     * @param xmlFileName The name of the XML file containing the data.
     * @return A list of authors transformed from the XML data.
     * @throws JAXBException If a JAXB error occurs during transformation.
     */
    public static List<Author> transformToPOJO(String xmlFileName) throws JAXBException {
        File file = new File(xmlFileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(AuthorListWrapper.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        AuthorListWrapper wrapper = (AuthorListWrapper) unmarshaller.unmarshal(file);
        return wrapper.getAuthors();
    }
}
