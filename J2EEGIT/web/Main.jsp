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
        <title>MAIN PRINCIPAL</title>
    </head>
    <body>
        <!--        Prueba de peticiones de JSP-->
        <h1>
            ESTE ES EL MAIN
        </h1>
        <br/><br/><br/>
        
        <!--        AQUI INCRUSTA EL LOGIN DENTRO DEL MAIN-->
        <jsp:include page="Login.jsp"></jsp:include>
        
    </body>
</html>
