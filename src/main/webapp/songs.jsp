<%@ page import="model.Song" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <link
            href="https://cdn.jsdelivr.net/npm/daisyui@2.6.0/dist/full.css"
            rel="stylesheet"
            type="text/css"
    />
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Songs</title>
</head>
<body data-theme="dark">
<div class="navbar flex justify-center bg-primary mb-8">
    <a class="btn btn-ghost text-xl text-primary-content" href="/songs">☕ JSP Songs 🎵</a>
</div>

<% Object error = request.getAttribute("error"); %>

<div class="container m-auto w-3/5">
    <h1 class="text-xl text-center mb-8">Add a new song</h1>

    <% if (error != null) {
        out.println("<p>");
        out.println(error);
        out.println("</p>");
    }
    %>

    <form class="flex flex-col gap-4 items-stretch w-2/4 mb-8 m-auto" action="/songs" method="post">
        <div>
            <input type="text" placeholder="Title of the song" id="title" name="title"
                   class="input input-bordered w-full" required/>
        </div>
        <div>
            <input type="text" placeholder="Name of the artist" id="artistName" name="artistName"
                   class="input input-bordered w-full" required/>
        </div>
        <div>
            <input type="text" placeholder="Genre" id="genre" name="genre"
                   class="input input-bordered w-full" required/>
        </div>

        <input type="submit" value="Submit" class="btn btn-primary self-center mt-4"/>
    </form>

    <div class="overflow-x-auto rounded">
        <table class="table table-zebra w-full">
            <thead>
            <tr>
                <th>Title</th>
                <th>Artist</th>
                <th>Genre</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Song song : (List<Song>) request.getAttribute("songs")) {
                    out.println("<tr>");
                    out.println("<td>" + song.getTitle() + "</td>");
                    out.println("<td>" + song.getArtistName() + "</td>");
                    out.println("<td>" + song.getGenre() + "</td>");
                    out.println("<td><a href=\"?songId=" + song.getId() + "\">Edit</a></td>");
                    out.println("<td><a href=\"#\">Delete</a></td>");
                    out.println("</tr>");
                }
            %>
            </tbody>
        </table>
    </div>
</div>

</body>