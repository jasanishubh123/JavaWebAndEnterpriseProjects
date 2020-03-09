<%-- 
    Document   : logout
    Created on : 6 Mar, 2020, 4:58:29 PM
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
        <%
            request.logout();
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
