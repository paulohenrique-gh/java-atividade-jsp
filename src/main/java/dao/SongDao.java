package dao;

import db.DbConnect;
import model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongDao {

    Connection connection;

    public SongDao() {
        this.connection = DbConnect.getConnection();
    }

    public void addSong(Song song) {
        try {
            String sql = "INSERT INTO song(title, artistName, durationInSeconds, genre), VALUES (?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, song.getTitle());
            pst.setString(2, song.getArtistName());
            pst.setInt(3, song.getDurationInSeconds());
            pst.setString(4, song.getGenre());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error while inserting song: " + ex.getMessage());
        }
    }

    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Error while getting all songs: " + e.getMessage());
        }

        return songs;
    }
}
