<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chuck Quotes: Add Quote</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/style.css" rel="stylesheet" media="screen">
</head>
<body>
<div class="container container-content">
    <h1>Chuck Quotes: Add Quote</h1>

    <div style="text-align:right">
        <c:url var="logout_url" value="/login_servlet">
            <c:param name="command" value="logout"/>
        </c:url>
        <button onclick="location.href='${logout_url}'" class="btn btn-success btn-logout">Log out</button>
    </div>

    <form id="add_quote" action="chuck_servlet" method="post">
        <textarea name="quote_text" form="add_quote"></textarea>
        <br/>
        <input type="submit" value="Confirm" class="btn btn-primary">

        <input type="hidden" name="command" value="confirm_add">
    </form>
    <c:url var="cancel_add_url" value="/chuck_servlet">
        <c:param name="command" value="cancel_add"/>
    </c:url>
    <button onclick="location.href='${cancel_add_url}'" class="btn btn-default">Cancel</button>
</div>
</body>
</html>
