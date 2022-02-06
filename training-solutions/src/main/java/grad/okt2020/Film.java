package grad.okt2020;

import java.time.LocalDate;
import java.util.Optional;

public class Film {
    private Optional<LocalDate> releaseDate;
    private String title;
    private int season;
    private int episode;
    private int length;
    private boolean seen;

    public Film(Optional<LocalDate> releaseDate, String title, int season, int episode, int length, boolean seen) {
        this.releaseDate = releaseDate;
        this.title = title;
        this.season = season;
        this.episode = episode;
        this.length = length;
        this.seen = seen;
    }

    public Optional<LocalDate> getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public int getSeason() {
        return season;
    }

    public int getEpisode() {
        return episode;
    }

    public int getLength() {
        return length;
    }

    public boolean isSeen() {
        return seen;
    }
}
