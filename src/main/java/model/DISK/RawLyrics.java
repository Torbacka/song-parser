package model.DISK;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * RawLyrics is a simple model for a lyrics
 */

public class RawLyrics {
    @XmlElement
    private String title;
    @XmlElement
    private String melody;
    @XmlElement
    private String text;

    public RawLyrics() {

    }

    public RawLyrics(String title, String melody, String text) {

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
