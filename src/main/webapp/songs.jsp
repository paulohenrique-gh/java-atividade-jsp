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
<body data-theme="coffee">
<div class="navbar flex justify-center bg-primary">
    <a class="btn btn-ghost text-xl text-primary-content">☕ JSP Songs 🎵</a>
</div>

<div class="container m-auto w-3/5">
    <h1>Add a new song</h1>

    <form>
        <div>
            <input type="text" placeholder="Title of the song" id="title" name="title"
                   class="input input-bordered w-full max-w-xs"/>
        </div>
        <div>
            <input type="text" placeholder="name of the artist" id="artistname" name="artistname"
                   class="input input-bordered w-full max-w-xs"/>
        </div>
        <div>
            <input type="text" placeholder="name of the artist" id="genre" name="genre"
                   class="input input-bordered w-full max-w-xs"/>
        </div>

        <input type="submit" value="Submit" class="btn"/>
    </form>
</div>

</body>