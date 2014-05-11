<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chuck Quotes</title>
</head>
<body>
<jsp:useBean id="quotesRegistry" class="ua.kpi.fpm.pma.oop.chuckquotes.QuotesRegistry" scope="page"/>

<table border="1">
    <c:set var="index" value="0" scope="page"/>
    <c:forEach var="quote" items="${pageScope.quotesRegistry.allQuotes}">
        <c:set var="index" value="${index + 1}"/>
        <tr>
            <td>${index}</td>
            <td>${quote}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
