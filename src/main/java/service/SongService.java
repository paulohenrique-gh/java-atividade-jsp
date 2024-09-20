package service;

import dao.SongDao;
import model.Song;

import java.util.List;

public class SongService {

    private final SongDao songDao;

    public SongService() {
        this.songDao = new SongDao();
    }

    public void addSong(Song song) {
        this.validateFields(song);

        this.songDao.addSong(song);
    }

    public List<Song> getAllSongs() {
        return this.songDao.getAllSongs();
    }

    public Song getSongById(int id) {
        return this.songDao.getSongById(id);
    }

    public void updateSong(Song song) {
        this.validateFields(song);

        this.songDao.updateSong(song);
    }

    public void deleteSong(int songId) {
        this.songDao.deleteSong(songId);
    }

    private void validateFields(Song song) {
        String title = song.getTitle();
        String artistName = song.getArtistName();
        String genre = song.getGenre();

        if (title.isEmpty() || artistName.isEmpty() || genre.isEmpty()) {
            throw new RuntimeException("Title, artist name and genre cannot be empty");
        }
    }
}
