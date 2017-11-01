package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Title {
    @XmlAttribute
    private String text;
    @XmlElement
    private List<String> alternativeTitle;

    public Title(String text, List<String> alternativeTitle) {
        this.text = text;
        this.alternativeTitle = alternativeTitle;
    }

    public String getText() {
        return text;
    }

    public List<String> getAlternativeTitle() {
        return alternativeTitle;
    }
}
