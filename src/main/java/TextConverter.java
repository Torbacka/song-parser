import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import business.SongbookParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Lyrics;
import model.XmlRoot;

/**
 * Created by Daniel on 2017-02-06.
 */
public class TextConverter {

    public static void main(String[] args) {
        try {
            TextConverter textConverter = new TextConverter();
            textConverter.convert();
        } catch (Exception e) {
            System.err.println("Cought error while parsing songbook: \n");
            e.printStackTrace();
        }
    }

    private void convert() throws URISyntaxException, IOException, JAXBException {
        File file = new File(getClass().getResource("songbook.txt").toURI());
        SongbookParser songbookParser = new SongbookParser();
        List<Lyrics> lyrics = songbookParser.parse(file.getAbsolutePath());
        writeToJson(lyrics);
        writeToXml(lyrics);
    }

    private void writeToXml(List<Lyrics> lyrics) throws JAXBException, IOException {
        XmlRoot xmlRoot = new XmlRoot(lyrics);
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlRoot.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(xmlRoot, new FileWriter(new File("lyrics.xml")));
    }

    private void writeToJson(List<Lyrics> lyrics) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("lyrics.json"), lyrics);
    }
}
