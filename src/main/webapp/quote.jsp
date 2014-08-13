<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chuck Quotes: Mortal user</title>
</head>
<body>
<h1>Chuck Quotes: Mortal user's page</h1>
<div style="text-align:right">
    <c:url var="logout_url" value="/login_servlet">
        <c:param name="command" value="logout"/>
    </c:url>
    <button onclick="location.href='${logout_url}'">Log out</button>
</div>
<hr/>
<img src="img/chuck.jpg" />
<br/>
<blockquote>${quote.text}</blockquote>
<br/>
<c:url var="next_quote_url" value="/chuck_servlet">
    <c:param name="command" value="next_quote"/>
</c:url>
<button onclick="location.href='${next_quote_url}'">Next Quote</button>
</body>
</html>
