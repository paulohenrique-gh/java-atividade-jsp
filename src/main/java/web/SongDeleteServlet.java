package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.SongService;

import java.io.IOException;

@WebServlet("/songs/delete")
public class SongDeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final SongService songService;

    public SongDeleteServlet() {
        super();
        this.songService = new SongService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String songId = req.getParameter("songId");
        this.songService.deleteSong(Integer.parseInt(songId));

        resp.sendRedirect("/songs");
    }
}
