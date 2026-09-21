<%-- 
    Document   : login
    Created on : Sep 17, 2026, 11:11:42 PM
    Author     : mohammad-mustafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <form action="/mvcproject/fc/models/login" method="POST">
            <input type="email" name="email" placeholder="Email"/>
            <br><br>
            <input type="password" name="password" placeholder="Password"/>
            <br><br>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
