package model;

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
    private List<Lyrics> lyrics;

    public XmlRoot() {

    }

    public XmlRoot(List<Lyrics> lyricss) {
        this.lyrics = lyricss;
    }

    public List<Lyrics> getLyricss() {
        return lyrics;
    }
}
