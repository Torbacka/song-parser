package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Title {
    @XmlAttribute
    private String title;
    @XmlElement
    private List<String> alternativeTitle;

    public String getTitle() {
        return title;
    }

    public List<String> getAlternativeTitle() {
        return alternativeTitle;
    }
}
