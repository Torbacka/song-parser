package model.DISK;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

/**
 * Created by Daniel on 2017-02-06.
 */
@XmlRootElement
@XmlSeeAlso({Lyrics.class})
public class XmlRoot {
    @XmlElement
    private List<Song> lyrics;

    public XmlRoot() {

    }

    public XmlRoot(List<Song> lyricss) {
        this.lyrics = lyricss;
    }

    public List<Song> getLyricss() {
        return lyrics;
    }
}
