package business.DISK;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import data.DiskData;
import model.DISK.DiskSong;
import model.Song;
import model.SongBook;
import model.Text;
import model.Title;

public class DiskConverter {

    public SongBook convertDiskSong(DiskData diskData) {
        List<DiskSong> diskSongs = diskData.getSongs();
        List<Song> songs = diskSongs.stream()
                .map(this::convertDiskSong)
                .collect(Collectors.toList());
        return new SongBook(LocalDate.now(), songs);

    }

    private Song convertDiskSong(DiskSong diskSong) {
        DiskParser diskParser = new DiskParser();
        Text text = diskParser.parse(diskSong.getText());
        Title title = new Title(diskSong.getTitle(), null);
        List<String> auhtors = Arrays.asList(diskSong.getAuthor());
        return new Song(text, title, auhtors, null, diskSong.getFact(), Double.MIN_VALUE);
    }

}
