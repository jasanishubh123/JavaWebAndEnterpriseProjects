<%-- 
    Document   : login
    Created on : 6 Mar, 2020, 4:42:31 PM
    Author     : shubham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="jaas/jasslogin.jsp"> 
            Username: <input type="text" name="username"/>
            <br><br>
            Password : <input type="password" name="password"/><br><br>
            <input type="submit" value="login">
        </form>
    </body>
</html>
