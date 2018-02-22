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
            <input type="text" name="userName" value= "${user.userName}" />
            <input type="text" name="userName" />
        </form>
    </body>
</html>