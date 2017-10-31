package business;

import model.DISK.Lyrics;
import model.DISK.RawLyrics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Daniel on 2017-02-05.
 */
public class SongbookParser {

    public List<Lyrics> parse(String filename) throws IOException {
        List<String> songbookLines = Files.readAllLines(Paths.get(filename));
        List<RawLyrics> rawLyrics = parseRawSongbook(songbookLines);
        List<Lyrics> lyrics = new ArrayList<>();
        for (RawLyrics raw : rawLyrics) {
            lyrics.add(parseRawLyrics(raw));
        }
        return lyrics;
    }

    private List<RawLyrics> parseRawSongbook(List<String> songbookLines) {
        String title = "";
        String melody = "";
        String lyrics = "";
        String lastRow = "";
        List<RawLyrics> rawLyricss = new ArrayList<>();

        for (String row : songbookLines) {
            lyrics += row + '\n';
            if (row.toLowerCase().startsWith("mel")) {
                if (!title.isEmpty() && !melody.isEmpty()) {
                    rawLyricss.add(new RawLyrics(title, melody, trimLyrics(lyrics)));
                }
                title = lastRow;
                melody = row.substring(row.indexOf(":") + 1).trim();
                lyrics = "";
            }
            lastRow = row;
        }
        rawLyricss.add(new RawLyrics(title, melody, lyrics));
        return rawLyricss;
    }

    //Remove last rows
    private String trimLyrics(String lyrics) {

        String temp = lyrics.substring(0, lyrics.toLowerCase().indexOf("\nmel"));
        return temp.substring(0, temp.lastIndexOf("\n"));
    }

    private Lyrics parseRawLyrics(RawLyrics rawLyrics) {
        String text = rawLyrics.getText();
        String[] rows = text.split("\n");
        List<String> verses = new ArrayList<>();
        Map<String, String> extraInformations = new HashMap<>();
        String verse = "";
        for (String row : rows) {
            if (row.isEmpty()) {
                if(!verse.isEmpty())
                    verses.add(verse);
                verse = "";
                continue;
            }
            if (containsExtraInfo(row)) {
                String[] split = row.split(":");
                String information = "";
                for(int i = 1; i < split.length;i++){
                    information += split[i];
                }
                extraInformations.put(split[0], information);

            } else {
                verse += row + "\n";
            }

        }
        if(!verse.isEmpty())
            verses.add(verse);
        return new Lyrics(rawLyrics, verses, extraInformations);
    }

    private boolean containsExtraInfo(String row) {
        if (row.isEmpty() || row.equals(" "))
            return false;
        String[] split = row.split(" ");
        try {
            return split[0].contains(":");

        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return false;
    }

}
