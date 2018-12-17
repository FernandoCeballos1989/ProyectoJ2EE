<%-- 
    Document   : addUser
    Created on : 12-dic-2018, 16:25:31
    Author     : Fernando ceballos <fernandoceballos1989@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" href="css/style.css"/>
        <title>UPDATE USER</title>
    </head>
    <body>

        <!--        AQUI INCRUSTA LA CABECERA-->
        <jsp:include page="/Templates/HeaderLogout.jsp"></jsp:include>

            <main class="main">

                <div class="container">

                    <!--Necesita que al pulsar el boton , los datos viajen al controlador-->
                    <form name="formAdd" method="get" action="ControllerUsuario">

                        <!--AQUÍ SE INTRODUCE UN VALOR INVISIBLE QUE AYUDARÁ A IDENTIFICAR LA 
                            ACCIÓN DE UPDATE , EN EL MÉTODO DOGET DEL CONTROLADOR-->
                        <input type="hidden" name="instruccion" value="updateUserBBDD">
                        <!--IDENTIFICA EL ID QUE RECIBE DESDE EL ControllerUsuario.java-->
                        <input type="hidden" name="idUserForm" value="${usuarioActualizar.idUser}">

                    <!--EL NAME ES EL QUE IDENTIFICARÁ CADA ATRIBUTO EN EL ControllerUsuario.java-->
                    NICK<input id="nick" type="text" name="nickForm" value="${usuarioActualizar.nickUser}"><br/>
                    NOMBRE<input id="nombre" type="text" name="nombreForm" value="${usuarioActualizar.nombreUser}"><br/>
                    EMAIL<input id="email" type="text" name="emailForm" value="${usuarioActualizar.emailUser}"><br/>
                    PASS<input id="pass" type="text" name="passForm" value="${usuarioActualizar.passUser}"><br/>
                    <input id="submit" type="submit" value="UPDATE!">

                </form>

            </div>


        </main>

        <jsp:include page="/Templates/Footer.jsp"></jsp:include>    

        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="js/javascript.js"></script>
    </body>
</html>
