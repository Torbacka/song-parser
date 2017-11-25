package business;

import java.time.LocalDate;
import java.util.List;

import model.Song;
import model.SongBook;
import org.assertj.core.util.Lists;

public class SongBookBuilder {

    private SongBook value = null;

    private void init() {
        value = new SongBook(LocalDate.now(), Lists.emptyList());
    }

    public SongBook getValue() {
        return value;
    }

    public SongBookBuilder append(SongBook songBook) {
        if (songBook == null) {
            return this;
        }
        List<Song> builderSong = value.getSongs();

        return this;
    }


}
