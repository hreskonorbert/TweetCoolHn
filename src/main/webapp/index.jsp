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

    <form action="login" method="post" id="loginForm">
        <input type="text" id="name" name="name" placeholder="username">
        <input type="password" name="password" placeholder="password">
        <input id="loginButton" type="submit" value="Log in">
    </form>

</body>
</html>
