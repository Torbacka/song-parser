package model.IN;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.FIELD)
public class Song {
    @XmlAttribute
    private String author;
    @XmlAttribute
    private String composer;
    @XmlAttribute
    private String category;
    @XmlAttribute
    private String name;
    @XmlElement
    private String[] p;
    @XmlAttribute
    private String melody;
    public Song() {

    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getP() {
        return p;
    }

    public void setP(String[] p) {
        this.p = p;
    }

    public String getMelody() {
        return melody;
    }

    public void setMelody(String melody) {
        this.melody = melody;
    }

    @Override
    public String toString() {
        return "ClassPojo [author = " + author + ", composer = " + composer + ", category = " + category + ", name = " + name + ", p = " + p + ", melody = " + melody + "]";
    }
}
