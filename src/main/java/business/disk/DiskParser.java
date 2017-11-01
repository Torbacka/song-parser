package business.disk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.DISK.Lyrics;
import model.DISK.RawLyrics;
import model.Text;
import org.apache.log4j.Logger;

/**
 * Created by Daniel on 2017-02-05.
 */
public class DiskParser {
    private static final Logger LOG = Logger.getLogger(DiskParser.class);

    public Text parse(String text) {
        String[] verses = text.split("\n\n");
        return new Text(Arrays.asList(verses), null);
    }

    public List<Lyrics> parse(Path filePath) throws IOException {
        List<String> songbookLines = Files.readAllLines(filePath);
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
        StringBuilder lyricsBuilder = new StringBuilder();
        String lastRow = "";
        List<RawLyrics> rawLyricss = new ArrayList<>();

        for (String row : songbookLines) {
            lyricsBuilder.append(row).append('\n');
            if (row.toLowerCase().startsWith("mel")) {
                if (!title.isEmpty() && !melody.isEmpty()) {
                    rawLyricss.add(new RawLyrics(title, melody, trimLyrics(lyricsBuilder.toString())));
                }
                title = lastRow;
                melody = row.substring(row.indexOf(':') + 1).trim();
                lyricsBuilder = new StringBuilder();
            }
            lastRow = row;
        }
        rawLyricss.add(new RawLyrics(title, melody, lyricsBuilder.toString()));
        return rawLyricss;
    }

    //Remove last rows
    private String trimLyrics(String lyrics) {

        String temp = lyrics.substring(0, lyrics.toLowerCase().indexOf("\nmel"));
        return temp.substring(0, temp.lastIndexOf('\n'));
    }

    private Lyrics parseRawLyrics(RawLyrics rawLyrics) {
        String text = rawLyrics.getText();
        String[] rows = text.split("\n");
        List<String> verses = new ArrayList<>();
        Map<String, String> extraInformations = new HashMap<>();
        StringBuilder verse = new StringBuilder();
        for (String row : rows) {
            if (row.isEmpty()) {
                if(verse.length() != 0)
                    verses.add(verse.toString());
                verse = new StringBuilder();
                continue;
            }
            if (containsExtraInfo(row)) {
                String[] split = row.split(":");
                StringBuilder information = new StringBuilder();
                for(int i = 1; i < split.length;i++){
                    information.append(split[i]);
                }
                extraInformations.put(split[0], information.toString());

            } else {
                verse.append(row).append('\n');
            }

        }
        if((verse.length() != 0))
            verses.add(verse.toString());
        return new Lyrics(rawLyrics, verses, extraInformations);
    }

    private boolean containsExtraInfo(String row) {
        if (row.isEmpty() || row.equals(" "))
            return false;
        String[] split = row.split(" ");
        try {
            return split[0].contains(":");

        }catch (ArrayIndexOutOfBoundsException e) {
            LOG.error(e);
        }
        return false;
    }

}
