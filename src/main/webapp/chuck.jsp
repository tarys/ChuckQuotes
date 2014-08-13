<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chuck Quotes: Chuck Page</title>
</head>
<body>
<h1>Chuck Quotes: Chuck Page</h1>
<div style="text-align:right">
    <c:url var="logout_url" value="/login_servlet">
        <c:param name="command" value="logout"/>
    </c:url>
    <button onclick="location.href='${logout_url}'">Log out</button>
</div>
<hr/>
<jsp:useBean id="quotesRegistry" class="ua.jug.chuckquotes.quote.QuotesRegistry" scope="application"/>
<table border="1">
    <c:forEach var="quote" items="${applicationScope.quotesRegistry.all}">
        <tr>
            <td>${quote.text}</td>
            <td>
                <c:url var="edit_url" value="/chuck_servlet">
                    <c:param name="command" value="edit"/>
                    <c:param name="quote_index" value="${quote.index}"/>
                </c:url>
                <button onclick="location.href='${edit_url}'">Edit</button>
            </td>
            <td>
                <c:url var="remove_url" value="/chuck_servlet">
                    <c:param name="command" value="remove"/>
                    <c:param name="quote_index" value="${quote.index}"/>
                </c:url>
                <button onclick="location.href='${remove_url}'">Remove</button>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<c:url var="add_url" value="/chuck_servlet">
    <c:param name="command" value="add"/>
</c:url>
<button onclick="location.href='${add_url}'">Add Quote</button>

</body>
</html>
