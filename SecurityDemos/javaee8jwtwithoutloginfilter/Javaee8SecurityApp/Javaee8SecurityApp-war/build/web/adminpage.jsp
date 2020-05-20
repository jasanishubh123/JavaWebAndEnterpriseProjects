<%-- 
    Document   : adminpage
    Created on : 4 Mar, 2020, 1:39:45 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
           // @Inject private SecurityContext ctx;
            %>
            <%
               
                if(!request.isUserInRole("Admin"))
                {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN,"Not Allowed");
                }
                %>
        
        <h1>Hello World!</h1>
    </body>
</html>
