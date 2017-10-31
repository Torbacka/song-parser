package model.DISK;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Song {
    @JsonProperty
    private String title;
    @JsonProperty
    private String melody;
    @JsonProperty
    private String author;
    @JsonProperty
    private String text;
    @JsonProperty
    private String fact;

    public Song(String title, String melody, String author, String text, String fact) {
        this.title = title;
        this.melody = melody;
        this.author = author;
        this.text = text;
        this.fact = fact;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMelody() {
        return melody;
    }

    public void setMelody(String melody) {
        this.melody = melody;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}