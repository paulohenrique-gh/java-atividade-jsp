package model;

public class Song {
    private int id;
    private String title;
    private String artistName;
    private int durationInSeconds;
    private String genre;

    public Song(int id, String title, String artistName, int durationInSeconds, String genre) {
        this.id = id;
        this.title = title;
        this.artistName = artistName;
        this.durationInSeconds = durationInSeconds;
        this.genre = genre;
    }

    public Song() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
