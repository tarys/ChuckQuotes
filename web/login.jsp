<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuck Quotes: Login</title>
</head>
<body>
<h1>Chuck Quotes: Login</h1>
<form method="post" action="chuck_servlet">
    <table>
        <tr>
            <td>User Name :</td>
            <td><input type="text" name="username" value=""/>
            </td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><input type="password" name="password" value=""/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="command" value="login"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
