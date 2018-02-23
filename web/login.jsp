<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <p style="color: red;">${errorString}</p>

        <form method="POST" action="${pageContext.request.contextPath}/login">
            <input type="text" name="userName" value= "${user.userName}" /><br><br>
            <input type="text" name="password" /><br><br>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>