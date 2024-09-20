package service;

import dao.SongDao;
import model.Song;

import java.util.List;

public class SongService {

    private SongDao songDao;

    public SongService() {
        this.songDao = new SongDao();
    }

    public void addSong(Song song) {
        this.validateInput(song);

        this.songDao.addSong(song);
    }

    public List<Song> getAllSongs() {
        return this.songDao.getAllSongs();
    }

    public Song getSongById(int id) {
        return this.songDao.getSongById(id);
    }

    public void updateSong(Song song) {
        this.validateInput(song);

        this.songDao.updateSong(song);
    }

    private void validateInput(Song song) {
        String title = song.getTitle();
        String artistName = song.getArtistName();
        String genre = song.getGenre();

        if (title.isEmpty() || artistName.isEmpty() || genre.isEmpty()) {
            throw new RuntimeException("Title, artist name and genre cannot be empty");
        }
    }
}
