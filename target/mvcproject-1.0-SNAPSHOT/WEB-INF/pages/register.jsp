<%-- 
    Document   : register
    Created on : Sep 18, 2026, 12:21:48 AM
    Author     : mohammad-mustafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <h1>Registration Form </h1>
        <form action="/mvcproject/fc/models/register" method="POST">
            <input type="email" name="email" placeholder="Email"/>
            <br/>
            <br/>
            <input type="password" name="password" placeholder="Password"/>
            <br/>
            <br/>
            <input type="text" name="fname" placeholder="FirstName"/>
            <br/>
            <br/>
            <input type="text" name="lname" placeholder="LastName"/>
            <br/>
            <br/>
            <input type="DATE" name="dob" placeholder="DOB"/>
            <br/>
            <br/>
            <div>
                Gender:
                <input id="maleGender" type="radio" name="gender" value="0"/>
                <label for="maleGender">Male</label>
                
                <input id="femaleGender" type="radio" name="gender" value="1"/>
                <label for="femaleGender">Female</label>
            </div>
            <br/>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
