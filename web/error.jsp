<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chuck Quotes: Error Page</title>
</head>
<body>
<h1>Chuck Quotes: Error Page</h1>
<div style="text-align:right">
    <c:url var="logout_url" value="/chuck_servlet">
        <c:param name="command" value="logout"/>
    </c:url>
    <button onclick="location.href='${logout_url}'">Log out</button>
</div>
<hr/>
</body>
</html>
