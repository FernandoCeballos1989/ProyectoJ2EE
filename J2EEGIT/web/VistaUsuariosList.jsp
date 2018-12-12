<%-- 
    Document   : VistaUsuariosList
    Created on : 12-dic-2018, 13:03:39
    Author     : Fernando ceballos <fernandoceballos1989@gmail.com>
--%>

<!--SCRIPTLETS PARA IMPORTACIONES-->
<%@page import="java.util.*,com.fernandoceballos.J2EEGIT.Entity.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VISTA DEL LISTADO DE USUARIOS</title>
    </head>
    
    <%
        //Se obtiene el listado de el controlador(ControllerUsuario.java)
        List<Usuarios> usuarios=(List<Usuarios>) request.getAttribute("listaUsuarios");
    %>
    
    <body>
        
        <!--        PRUEBA CORRECTA COMUNICACIÓN BBDD Y DE LECTURA -->
        <%= usuarios %>
        
    </body>
</html>
