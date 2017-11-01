package business;

import business.DISK.DiskConverter;
import business.IN.InConverter;
import data.DiskData;
import data.INData;
import model.SongBook;

public class SongConverter {
    private static final String IN_DATA_PATH = "src/main/resources/INSongs.xml";

    public SongBook convert() {
        DiskConverter diskConverter = new DiskConverter();
        SongBook diskSongBook = diskConverter.convert(new DiskData());

        InConverter inConverter = new InConverter();
        SongBook inSongBook =  inConverter.convert(new INData(IN_DATA_PATH));

        return SongBookCombineer.combine(diskSongBook, inSongBook);
    }

}
