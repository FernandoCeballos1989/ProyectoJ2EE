<%-- 
    Document   : listadoPrueba
    Created on : 11-dic-2018, 17:07:54
    Author     : Fernando ceballos <fernandoceballos1989@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--AÑADE TAGLIB PARA ETIQUETAS JSP -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--        LA ETIQUETA FOREACH , REQUIERE UNA VARIABLE EN LA QUE ALOJAR LOS DATOS
                Y UN ITEMS DE DONDE RECIBIMOS LOS MISMOS EN COLECCION , ESTE TIENE EL
                NOMBRE ESTABLECIDO EN NUESTRO CONTROLADOR EN EL METODO DOGET-->
        <c:forEach var="tempJuegos" items="${listajuegos}">
            ${tempJuegos}<br/>
        </c:forEach>
    </body>
</html>
