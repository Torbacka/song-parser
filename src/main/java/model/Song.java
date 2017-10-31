package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

@XmlSeeAlso({Title.class, Text.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Song {
    @XmlElement
    private Text text;
    @XmlAttribute
    private Title title;
    @XmlElement
    private List<String> authors;
    @XmlAttribute
    private String category;
    @XmlElement
    private String trivia;
    @XmlAttribute
    private double score;

    public Text getText() {
        return text;
    }

    public Title getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getCategory() {
        return category;
    }

    public String getTrivia() {
        return trivia;
    }

    public double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Song song = (Song) o;

        if (Double.compare(song.score, score) != 0) {
            return false;
        }
        if (!text.equals(song.text)) {
            return false;
        }
        if (!title.equals(song.title)) {
            return false;
        }
        if (authors != null ? !authors.equals(song.authors) : song.authors != null) {
            return false;
        }
        if (category != null ? !category.equals(song.category) : song.category != null) {
            return false;
        }
        return trivia != null ? trivia.equals(song.trivia) : song.trivia == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = text.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (trivia != null ? trivia.hashCode() : 0);
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
