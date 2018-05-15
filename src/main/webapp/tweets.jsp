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
    <form method="GET" action="new-tweet" id="filterForm">
        <input type="text" name="userFilter" placeholder="user to filter">
        <input type="submit" value="filter">
    </form>
    <div id="tweets">
    <c:forEach items="${tweets}" var="tweet">
        <div class="tweet">
        <p>${tweet.getContent()}</p>
        <h4 id="poster">Poster: ${tweet.getPoster()}</h3>
        </div>
    </c:forEach>
    </div>

    <a id="backToMainButton" href="homepage.jsp">Back</a>

</body>
</html>
