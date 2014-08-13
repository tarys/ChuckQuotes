<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chuck Quotes: Error Page</title>
</head>
<body>
<h1>Chuck Quotes: Error Page</h1>
<c:if test="${!empty sessionScope.user}">
    <div style="text-align:right">
        <c:url var="logout_url" value="/login_servlet">
            <c:param name="command" value="logout"/>
        </c:url>
        <button onclick="location.href='${logout_url}'">Log out</button>
    </div>
</c:if>
<hr/>
<h1>Don't mess with Chuck Norris!</h1>
<br/>
<img src="img/error.jpg"/>
</body>
</html>
