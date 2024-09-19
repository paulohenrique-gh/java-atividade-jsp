<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <title>Songs</title>
</head>
<body>

<h1>☕ JSP Songs 🎵</h1>

<h2>Add a new song</h2>

<form>
    <div>
        <label for="title">Title</label>
        <input type="text" id="title" name="title" required />
    </div>
    <div>
        <label for="artistName">Name of the artist</label>
        <input type="text" id="artistName" name="artistName" required />
    </div>
    <div>
        <label for="genre">Genre</label>
        <input type="text" id="genre" name="genre" required />
    </div>

    <input type="submit" value="Submit" />
</form>

</body>