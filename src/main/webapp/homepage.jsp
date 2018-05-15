<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <link rel="stylesheet" type="text/css" href="style.css">
            <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">

        <title>App</title>
    </head>
<body>

    <form action="new-tweet" method="post" id="postingForm">
        <input type="text" name="poster" placeholder="poster">
        <input type="text" name="content" placeholder="tweet">
        <input id="tweetButton" type="submit" value="Tweet">
    </form>

    <form action="new-tweet" method="get" id="checkTweets">
            <input id="postButton" type="submit" value="Check all tweets">
    </form>



</body>
</html>
