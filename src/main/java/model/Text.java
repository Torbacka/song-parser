package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Text {
    @XmlElement
    private List<String> verses;
    @XmlElement
    private List<String> extraVerses;

    public Text(List<String> verses, List<String> extraVerses) {
        this.verses = verses;
        this.extraVerses = extraVerses;
    }

    public List<String> getVerses() {
        return verses;
    }

    public List<String> getExtraVerses() {
        return extraVerses;
    }
}
