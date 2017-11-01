import business.DISK.DiskParser;
import model.DISK.Lyrics;
import model.DISK.RawLyrics;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 2017-02-05.
 */
public class SongbookParserTest {
    private DiskParser songbookParser;

    @Before
    public void init() {
        songbookParser = new DiskParser();
    }

    @Test
    public void textXML() throws JAXBException {
        RawLyrics rawLyrics = new RawLyrics("Test", "test2", "test");
        List<String> verses = new ArrayList<>();
        verses.add("södlfksdöflksdölfksdf");
        verses.add("södlfksdöflksdölfksdf");
        verses.add("södlfksdöflksdölfksdf");
        verses.add("södlfksdöflksdölfksdf");
        Map<String, String> extraInfomation = new HashMap<>();
        extraInfomation.put("Kat", "Intern");
        Lyrics lyrics = new Lyrics(rawLyrics, verses, extraInfomation);
        JAXBContext jaxbContext = JAXBContext.newInstance(Lyrics.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(lyrics, System.out);
    }

    @Test
    public void parseSongbook_shouldReturnSongs() throws IOException, URISyntaxException {
        //Arrange
        File resource = new File(this.getClass().getResource("/songbookTest.txt").toURI());
        // Act
        List<Lyrics> lyrics = songbookParser.parse(resource.getAbsolutePath());
        // Assert
        assertThat(lyrics).isNotNull();
    }


}