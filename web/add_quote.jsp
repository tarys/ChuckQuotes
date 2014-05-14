<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chuck Quotes: Add Quote</title>
</head>
<body>
<h1>Chuck Quotes: Add Quote</h1>
<form id="add_quote" action="chuck_servlet" method="post">
    <textarea name="quote_text" form="add_quote"></textarea>
    <br/>
    <input type="submit" value="Confirm">

    <input type="hidden" name="command" value="confirm_add">
</form>
<c:url var="cancel_add_url" value="/chuck_servlet">
    <c:param name="command" value="cancel_add"/>
</c:url>
<button onclick="location.href='${cancel_add_url}'">Cancel</button>
</body>
</html>
