<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chuck Quotes: Chuck Page</title>
</head>
<body>
<h1>Chuck Quotes: Chuck Page</h1>
<img src="img/chuck.jpg" height="50%">
<jsp:useBean id="quotesRegistry" class="ua.kpi.fpm.pma.oop.chuckquotes.QuotesRegistry" scope="page"/>

<form action="/chuck_servlet" method="get">
    <table border="1">
        <c:forEach var="quote" items="${pageScope.quotesRegistry.allQuotes}">
            <tr>
                <td>${quote.index + 1}</td>
                <td>${quote.text}</td>
                <td>
                    <input type="submit" name="${quote.index}" value="Edit" />
                </td>
                <td>
                    <input type="submit" name="${quote.index}" value="Remove" />
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" name="add" value="Add" />
</form>

</body>
</html>
