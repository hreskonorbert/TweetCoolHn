<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <link rel="stylesheet" type="text/css" href="${styleUrl}">

        <title>App</title>
    </head>
<body>

    <form action="new-tweet" method="post">
        <input type="text" name="poster" placeholder="poster">
        <input type="text" name="content" placeholder="tweet">
        <input type="submit" value="Tweet">
    </form>

    <form action="new-tweet" method="get">
        <input type="submit" value="Check all tweets">
    </form>
</body>
</html>
