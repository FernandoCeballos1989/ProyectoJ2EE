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
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" href="css/style.css"/>
        <title>VISTA DEL LISTADO DE USUARIOS</title>
    </head>


    <body>

        <!--        AQUI INCRUSTA LA CABECERA-->
        <jsp:include page="/Templates/HeaderLogout.jsp"></jsp:include>

            <main class="main">
                <div class="container">

                    <table class="tablausers" border="1">
                        <!--            CABECERA-->
                        <tr class="tabla-cabeceras">
                            <th>Nick</th>
                            <th>Nombre</th>
                            <th>Email</th>
                            <th>Action</th>
                        </tr>

                    <c:forEach var="uTemp" items="${listaUsuarios}">

                        <!--AQUÍ SE PASA EL ID DEL USUARIO SELECCIONADO AL CONTROLADOR(ControllerUsuario.java)-->
                        <c:url var="linkTemp" value="ControllerUsuario">
                            <c:param name="instruccion" value="AVistaUpdate"></c:param>
                            <c:param name="idUserLink" value="${uTemp.idUser}"></c:param>
                        </c:url>


                        <!--LINK PARA ELIMINAR-->
                        <c:url var="linkDelete" value="ControllerUsuario">
                            <c:param name="instruccion" value="delete"></c:param>
                            <c:param name="idUserLink" value="${uTemp.idUser}"></c:param>
                        </c:url>

                        <tr>
                            <!--ETIQUETAS JSP PARA CAPTURAR ATRIBUTOS , EL NOMBRE DEBE 
                            SER IGUAL AL QUE TIENE EN LA ENTITY-->
                            <td>${uTemp.nickUser}</td>
                            <td>${uTemp.nombreUser}</td>
                            <td>${uTemp.emailUser}</td>
                            <!--REFERENCIA CON EL LINK TEMPORAL DE ARRIBA PARA ENVIAR EL ID AL CONTROLADOR-->
                            <td><a href="${linkTemp}">Update</a>&nbsp;&nbsp;&nbsp;<a href="${linkDelete}">Delete</a></td>
                        </tr>

                    </c:forEach>



                </table>

                <div id="cntBtn">
                    <input type="button" value="add" onclick="window.location.href = 'VistaAddUser.jsp'"/>
                </div>
            </div>



        </main>
        <jsp:include page="/Templates/Footer.jsp"></jsp:include>    

        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="js/javascript.js"></script>


    </body>
</html>
