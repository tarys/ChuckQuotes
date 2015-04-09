<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chuck Quotes: Chuck Page</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/style.css" rel="stylesheet" media="screen">
</head>
<body>
<div class="container container-content">
    <h1>Chuck Quotes: Chuck Page</h1>

    <div style="text-align:right">
        <c:url var="logout_url" value="/login_servlet">
            <c:param name="command" value="logout"/>
        </c:url>
        <button onclick="location.href='${logout_url}'" class="btn btn-success btn-logout">Log out</button>
    </div>
    <jsp:useBean id="quotesRegistry" class="ua.jug.chuckquotes.quote.QuotesRegistry" scope="application"/>
    <table class="table table-hover">
        <th>Quote</th>
        <th></th>
        <th></th>
        <c:forEach var="quote" items="${applicationScope.quotesRegistry.all}">
            <tr>
                <td>${quote.text}</td>
                <td>
                    <c:url var="edit_url" value="/chuck_servlet">
                        <c:param name="command" value="edit"/>
                        <c:param name="quote_index" value="${quote.index}"/>
                    </c:url>
                    <button onclick="location.href='${edit_url}'" class="btn btn-default">Edit</button>
                </td>
                <td>
                    <c:url var="remove_url" value="/chuck_servlet">
                        <c:param name="command" value="remove"/>
                        <c:param name="quote_index" value="${quote.index}"/>
                    </c:url>
                    <button onclick="location.href='${remove_url}'" class="btn btn-danger">Remove</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <c:url var="add_url" value="/chuck_servlet">
        <c:param name="command" value="add"/>
    </c:url>
    <button onclick="location.href='${add_url}'" class="btn btn-primary">Add Quote</button>
</div>
</body>
</html>
