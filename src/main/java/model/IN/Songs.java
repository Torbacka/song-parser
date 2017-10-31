package model.IN;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso( {Song.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Songs {
    @XmlElement
    private Song[] song;
    @XmlAttribute
    private String updated;
    @XmlAttribute
    private String description;

    public Songs() {

    }

    public Song[] getSong() {
        return song;
    }

    public void setSong(Song[] song) {
        this.song = song;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ClassPojo [song = " + song + ", updated = " + updated + ", description = " + description + "]";
    }
}