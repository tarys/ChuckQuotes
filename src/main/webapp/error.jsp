<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chuck Quotes: Error Page</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/style.css" rel="stylesheet" media="screen">
</head>
<body>
<div class="container container-content">
    <h1>Chuck Quotes: Error Page</h1>
    <c:if test="${!empty sessionScope.user}">
        <div style="text-align:right">
            <c:url var="logout_url" value="/login_servlet">
                <c:param name="command" value="logout"/>
            </c:url>
            <button onclick="location.href='${logout_url}'" class="btn btn-success btn-logout">Log out</button>
        </div>
    </c:if>

    <h1 class="text-warning">Don't mess with Chuck Norris!</h1>
    <br/>
    <img src="img/error.jpg" class="img-thumbnail"/></div>
</body>
</html>
