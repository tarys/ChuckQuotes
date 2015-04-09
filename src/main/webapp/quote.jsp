<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chuck Quotes: Mortal user</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/style.css" rel="stylesheet" media="screen">
</head>
<body>
<div class="container container-content">
    <h1>Chuck Quotes: Mortal user's page</h1>

    <div style="text-align:right">
        <c:url var="logout_url" value="/login_servlet">
            <c:param name="command" value="logout"/>
        </c:url>
        <button onclick="location.href='${logout_url}'" class="btn btn-success btn-logout">Log out</button>
    </div>

    <img src="img/chuck.jpg" class="img-thumbnail"/>
    <blockquote style="margin-top: 20px">
        <p>${quote.text}</p>
    </blockquote>
    <br/>
    <c:url var="next_quote_url" value="/chuck_servlet">
        <c:param name="command" value="next_quote"/>
    </c:url>
    <button onclick="location.href='${next_quote_url}'" class="btn btn-default">Next Quote</button>
</div>
</body>
</html>
