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
        <title>ADD USER</title>
    </head>
    <body>

        <!--        AQUI INCRUSTA LA CABECERA-->
        <jsp:include page="/Templates/HeaderLogout.jsp"></jsp:include>

            <main class="main">

                <div class="container">

                    <!--Necesita que al pulsar el boton , los datos viajen al controlador-->
                    <form name="formAdd" method="get" action="ControllerUsuario">

                        <!--AQUÍ SE INTRODUCE UN VALOR INVISIBLE QUE AYUDARÁ A IDENTIFICAR LA 
                            ACCIÓN DE ADD , EN EL MÉTODO DOGET DEL CONTROLADOR-->
                        <input type="hidden" name="instruccion" value="addUser">

                        <!--EL NAME ES EL QUE IDENTIFICARÁ CADA ATRIBUTO EN EL ControllerUsuario.java-->
                        <input id="nick" type="text" name="nickForm" placeholder="Nick"><br/>
                        <input id="nombre" type="text" name="nombreForm" placeholder="Nombre"><br/>
                        <input id="email" type="text" name="emailForm" placeholder="E-MAIL"><br/>
                        <input id="pass" type="text" name="passForm" placeholder="pass"><br/>
                        <input id="submit" type="submit" value="ADD!">

                        </div>
                    </form>

            </main>

        <jsp:include page="/Templates/Footer.jsp"></jsp:include>    

        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="js/javascript.js"></script>



    </body>
</html>
