<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Choisissez votre option" %>
</h1>
<br/>
<form method="post" action="login-servlet">
    <div class="container">
        <label for="uname">Username</label>
        <input type="text" placeholder="Enter Username" name="uname" required>
    </div>
    <div class="container">
        <label for="pwd">Password</label>
        <input type="text" placeholder="Enter Password" name="pwd" required>
    </div>
    <button type="submit" value="login">Login</button>
</form>
</body>
</html>