<%-- 
    Document   : Main
    Created on : 11-dic-2018, 16:09:33
    Author     : Fernando ceballos <fernandoceballos1989@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MAIN log-in</title>
    </head>
    <body>
        <!--        Prueba de peticiones de JSP-->
        <h1>
            usuario:<%=request.getParameter("user") %>
            <br/>
            PASS:<%=request.getParameter("passwd") %>
        </h1>
    </body>
</html>
