<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuck Quotes: Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/style.css" rel="stylesheet" media="screen">
</head>
<body>
<div class="container-login">
    <form method="post" action="login_servlet" class="form-signin">
        <h2 class="form-signin-heading">Chuck Quotes: Login</h2>
        <input type="text" class="input-block-level" name="username" placeholder="User Name"/>
        <input type="password" class="input-block-level" name="password" placeholder="Password"/>
        <input type="submit" name="command" value="login" class="btn btn-large btn-primary"/>
    </form>
</div>
</body>
</html>
