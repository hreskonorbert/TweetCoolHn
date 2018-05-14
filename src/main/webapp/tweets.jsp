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

    <div id="tweets">
    <c:forEach items="${tweets}" var="tweet">
        <h3>Tweet: ${tweet.getContent()}</h4>
        <h4>Poster: ${tweet.getPoster()}</h3>
    </c:forEach>
    </div>

    <a href="homepage.jsp">Back</a>

</body>
</html>
