<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chuck Quotes: Edit Quote</title>
</head>
<body>
<h1>Chuck Quotes: Edit Quote</h1>
<div style="text-align:right">
    <c:url var="logout_url" value="/chuck_servlet">
        <c:param name="command" value="logout"/>
    </c:url>
    <button onclick="location.href='${logout_url}'">Log out</button>
</div>
<hr/>
<form id="edit_quote" action="chuck_servlet" method="post">
    <textarea name="quote_text" form="edit_quote">${requestScope.quoteToEdit.text}</textarea>
    <br/>
    <input type="submit" value="Confirm">

    <input type="hidden" name="command" value="confirm_edit">
    <input type="hidden" name="quote_index" value="${requestScope.quoteToEdit.index}">
</form>
<c:url var="cancel_edit_url" value="/chuck_servlet">
    <c:param name="command" value="cancel_edit"/>
</c:url>
<button onclick="location.href='${cancel_edit_url}'">Cancel</button>
</body>
</html>
