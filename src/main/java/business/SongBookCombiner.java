package business;

import model.SongBook;

class SongBookCombiner {

    private SongBookCombiner() {
    }

    static SongBook combine(SongBook... songBooks) {
        SongBookBuilder songBookBuilder = new SongBookBuilder();
        for(SongBook songBook : songBooks) {
            songBookBuilder.append(songBook);
        }
        return songBookBuilder.getValue();
    }
}
