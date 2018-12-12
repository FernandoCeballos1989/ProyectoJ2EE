<%-- 
    Document   : VistaUsuariosList
    Created on : 12-dic-2018, 13:03:39
    Author     : Fernando ceballos <fernandoceballos1989@gmail.com>
--%>

<!--AÑADE TAGLIB PARA ETIQUETAS JSP -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VISTA DEL LISTADO DE USUARIOS</title>
    </head>



    <body>

        <table>
            <!--            CABECERA-->
            <tr>
                <th>Nick</th>
                <th>Nombre</th>
                <th>Email</th>
            </tr>

            <c:forEach var="uTemp" items="${listaUsuarios}">

                <tr>
                    <!--ETIQUETAS JSP PARA CAPTURAR ATRIBUTOS , EL NOMBRE DEBE 
                    SER IGUAL AL QUE TIENE EN LA ENTITY-->
                    <td>${uTemp.nickUser}</td>
                    <td>${uTemp.nombreUser}</td>
                    <td>${uTemp.emailUser}</td>
                </tr>

            </c:forEach>



        </table>

    </body>
</html>
