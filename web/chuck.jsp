<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chuck Quotes: Chuck Page</title>
</head>
<body>
<h1>Chuck Quotes: Chuck Page</h1>
<img src="img/chuck.jpg" height="50%">
<jsp:useBean id="quotesRegistry" class="ua.kpi.fpm.pma.oop.chuckquotes.QuotesRegistry" scope="application"/>

<table border="1">
    <c:forEach var="quote" items="${applicationScope.quotesRegistry.all}">
        <tr>
            <td>${quote.text}</td>
            <td>
                <a href="chuck_servlet?command=edit&quote_index=${quote.index}">Edit</a>
            </td>
            <td>
                <a href="chuck_servlet?command=remove&quote_index=${quote.index}">Remove</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
