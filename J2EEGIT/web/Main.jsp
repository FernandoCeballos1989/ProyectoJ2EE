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
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" href="css/style.css"/>
        <title>MAIN PRINCIPAL</title>
    </head>
    <body>
        <!--        AQUI INCRUSTA LA CABECERA-->
        <jsp:include page="/Templates/Header.jsp"></jsp:include>

            <main class="main">
                <div class="container">
                    <p>
                        Lorem ipsum dolor sit amet consectetur adipiscing elit et quis, orci cubilia eget risus ultricies imperdiet aenean metus. Vestibulum quisque aliquet nullam accumsan aliquam ac litora neque venenatis proin, diam commodo ridiculus ultrices tempus egestas nascetur conubia nisl, est justo aptent parturient dignissim fermentum duis erat ullamcorper. Suspendisse placerat morbi natoque ligula auctor turpis mattis id, est cubilia himenaeos bibendum sociis porttitor varius, phasellus velit rhoncus lacinia erat sociosqu elementum.

                        Tortor est vel quis consequat nascetur dictumst ad porta, justo odio ante tincidunt cursus sociis arcu eleifend senectus, maecenas turpis lacus hendrerit congue potenti aptent. Semper nunc mattis habitasse ad natoque consequat aptent congue per, metus commodo cum orci inceptos vel nisi gravida sociis scelerisque, aliquet aliquam cubilia et dignissim montes purus nec. Bibendum lobortis fusce pharetra faucibus montes velit sodales quisque vivamus, ad magna duis luctus sociis pretium eu.
                    </p>
                </div>

            </main>


        <jsp:include page="/Templates/Footer.jsp"></jsp:include>    

        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="js/javascript.js"></script>
    </body>
</html>
