package web;

import dao.SongDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Song;

import java.io.IOException;

@WebServlet("/songs")
public class SongServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private SongDao songDao;

    public SongServlet() {
        super();
        this.songDao = new SongDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("songs.jsp");
        req.setAttribute("songs", this.songDao.getAllSongs());
        System.out.println("Songs in servlet: " + req.getAttribute("songs"));
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Song song = new Song();
        song.setTitle(req.getParameter("title"));
        song.setArtistName(req.getParameter("artistName"));
        song.setGenre(req.getParameter("genre"));

        this.songDao.addSong(song);

        RequestDispatcher dispatcher = req.getRequestDispatcher("songs.jsp");
        req.setAttribute("songs", this.songDao.getAllSongs());
        dispatcher.forward(req, resp);
    }
}
