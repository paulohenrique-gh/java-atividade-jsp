package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Song;
import service.SongService;

import java.io.IOException;

@WebServlet("/songs")
public class SongServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final SongService songService;

    public SongServlet() {
        super();
        this.songService = new SongService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("songId") != null) {
            String songId = req.getParameter("songId");
            Song song = this.songService.getSongById(Integer.parseInt(songId));

            RequestDispatcher dispatcher = req.getRequestDispatcher("edit-song.jsp");
            req.setAttribute("song", song);
            dispatcher.forward(req, resp);
            return;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("songs.jsp");
        req.setAttribute("songs", this.songService.getAllSongs());
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("songs.jsp");

        try {
            Song song = new Song();
            song.setTitle(req.getParameter("title"));
            song.setArtistName(req.getParameter("artistName"));
            song.setGenre(req.getParameter("genre"));

            this.songService.addSong(song);
        } catch (Exception e) {
            req.setAttribute("error", "All fields must be filled");
        }

        req.setAttribute("songs", this.songService.getAllSongs());
        dispatcher.forward(req, resp);
    }
}
