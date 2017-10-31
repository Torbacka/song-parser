package model.DISK;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;
import java.util.Map;

/**
 * Lyrics extends RawLyrics and contains infromation about verse and some extraInformation
 */
@XmlSeeAlso({RawLyrics.class})
public class Lyrics extends RawLyrics {
    @XmlElement
    private List<String> verses;
    @XmlElement
    private Map<String, String> extraInfomations;

    public Lyrics() {

    }

    public Lyrics(String title, String melody, String text, List<String> verses, Map<String, String> extraInfomations) {
        super(title, melody, text);
        this.verses = verses;
        this.extraInfomations = extraInfomations;
    }

    public Lyrics(RawLyrics rawLyrics, List<String> verses, Map<String, String> extraInfomations) {
        super(rawLyrics.getTitle(), rawLyrics.getMelody(), rawLyrics.getText());
        this.verses = verses;
        this.extraInfomations = extraInfomations;
    }

    public List<String> getVerses() {
        return verses;
    }

    public Map<String, String> getExtraInfomation() {
        return extraInfomations;
    }
}
