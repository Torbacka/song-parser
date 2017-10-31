package data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import model.IN.Songs;

public class INData {

    private Songs songs;

    public INData(String songPath) {
        init(songPath);
    }

    private void init(String songPath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Songs.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            songs = (Songs) jaxbUnmarshaller.unmarshal(new File(songPath));
        } catch (JAXBException e) {
            //ToDO add logger
            e.printStackTrace();
        }
    }

    public Songs getSongs() {
        return songs;
    }
}
