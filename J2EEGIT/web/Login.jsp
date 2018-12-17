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
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" href="css/style.css"/>
        <title>LOGIN</title>
    </head>


    <body>
        <!--        AQUI INCRUSTA LA CABECERA-->
        <jsp:include page="/Templates/Header.jsp"></jsp:include>
            <main class="main">
                
                <!-- CAJA LOGIN COMPUESTA -->
                <div id="login-box">
                    
                    <!-- CAJA IZQUIERDA -->
                    <div class="login-box-left">
                        <h1>SIGN UP</h1>

                        <!--Necesita que al pulsar el boton , los datos viajen al controlador-->
                        <form name="formLogin" method="get" action="ControllerLogin" >

                            <!--AQUÍ SE INTRODUCE UN VALOR INVISIBLE QUE AYUDARÁ A IDENTIFICAR LA 
                                ACCIÓN DE LOGIN , EN EL MÉTODO DOGET DEL CONTROLADOR-->
                            <input type="hidden" name="instruccion" value="credenciales">

                            <p> Nombre: <input type="text" name="nombreUser" id="user">
                            <p> Passwd:  <input type="password" name="passwdUser" id="passwd">
                            <p> <input type="submit" value="access">
                        </form>
                    </div>
                    
                    <!-- CAJA DERECHA -->
                    <div class="login-box-right">
                        <span class="signinwith">
                          
                        </span>
                        
                    </div>

                </div>
            </main>

        <jsp:include page="/Templates/Footer.jsp"></jsp:include>    

        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="js/javascript.js"></script>


    </body>
</html>
