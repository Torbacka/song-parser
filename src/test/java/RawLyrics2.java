import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * RawLyrics2 is a simple model for a lyrics
 */
 @XmlRootElement
public class RawLyrics2 {
    @XmlElement
    private String title;
    @XmlElement
    private String melody;
    @XmlElement
    private String text;

    public RawLyrics2() {

    }

    public RawLyrics2(String title, String melody, String text) {

        this.title = title;
        this.melody = melody;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getMelody() {
        return melody;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                "\nmelody='" + melody + '\'' +
                "\ntext='" + text + '\'';
    }
}
