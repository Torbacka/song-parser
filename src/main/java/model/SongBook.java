package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement
@XmlSeeAlso({Song.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class SongBook {
    @XmlAttribute
    private LocalDate publicationDate;
    @XmlElement
    private List<Song> songs;

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
