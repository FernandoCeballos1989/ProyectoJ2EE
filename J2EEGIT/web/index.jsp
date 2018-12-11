<%-- 
    Document   : index
    Created on : 11-dic-2018, 12:28:45
    Author     : Fernando ceballos <fernandoceballos1989@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"/>
        <script src="js/javascript.js"></script>
        <title>My Games Collection</title>
    </head>
    <body>
        <form action="Main.jsp" method="post">
            <p> Nombre: <input type="text" name="user" id="user">
            <p> Passwd:  <input type="password" name="passwd" id="passwd">
            <p> <input type="submit" value="access">
        </form>

        <!--        <input type="submit" value="HM" onclick="holaMundo()">-->
    </body>
</html>
