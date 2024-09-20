package dao;

import db.DbConnect;
import model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDao {

    Connection connection;

    public SongDao() {
        this.connection = DbConnect.getConnection();
    }

    public void addSong(Song song) {
        try {
            String sql = "INSERT INTO song(title, artist_name, genre) VALUES (?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, song.getTitle());
            pst.setString(2, song.getArtistName());
            pst.setString(3, song.getGenre());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error while inserting song: " + ex.getMessage());
        }
    }

    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM song");

            while (rs.next()) {
                Song song = new Song();

                song.setId(rs.getInt("id"));
                song.setTitle(rs.getString("title"));
                song.setArtistName(rs.getString("artist_name"));
                song.setGenre(rs.getString("genre"));

                songs.add(song);
            }
        } catch (SQLException e) {
            System.out.println("Error while getting all songs: " + e.getMessage());
        }

        return songs;
    }
}
