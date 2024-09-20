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

@WebServlet("/songs/update")
public class SongUpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final SongService songService;

        public SongUpdateServlet() {
        super();
        this.songService = new SongService();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Song song = new Song();

        try {
            song.setId(Integer.parseInt(req.getParameter("id")));
            song.setTitle(req.getParameter("title"));
            song.setArtistName(req.getParameter("artistName"));
            song.setGenre(req.getParameter("genre"));

            this.songService.updateSong(song);

            resp.sendRedirect("/songs");
        } catch (Exception e) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/edit-song.jsp");
            req.setAttribute("error", "All fields must be filled");
            req.setAttribute("song", song);
            dispatcher.forward(req, resp);
        }
    }
}
