import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

import business.SongConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.SongBook;
import org.apache.log4j.Logger;

/**
 * Created by Daniel on 2017-02-06.
 */
public class TextConverter {
    private static final Logger LOG = Logger.getLogger(TextConverter.class);
    public static void main(String[] args) {
        try {
            TextConverter textConverter = new TextConverter();
            textConverter.convert();
        } catch (Exception e) {
            LOG.error("Cought error while parsing songbook: \n", e);
        }
    }

    private void convert() throws URISyntaxException, IOException, JAXBException {
        SongConverter songConverter = new SongConverter();
        SongBook songBook = songConverter.convert();
        writeToJson(songBook);
        writeToXml(songBook);
    }

    private void writeToXml(SongBook songBook) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(SongBook.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(songBook, new FileWriter(new File("songs.xml")));
    }

    private void writeToJson(SongBook songBook) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("songs.json"), songBook);
    }
}
