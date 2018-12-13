/*
 * Clase Controladora para Usuarios.
 */
package com.fernandoceballos.J2EEGIT.Controller;

import com.fernandoceballos.J2EEGIT.Dao.UsuarioDao;
import com.fernandoceballos.J2EEGIT.Entity.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Fernando ceballos <fernandoceballos1989@gmail.com>
 */
@WebServlet(name = "ControllerUsuario", urlPatterns = {"/ControllerUsuario"})
public class ControllerUsuario extends HttpServlet {

    //Se declara el DAO
    private UsuarioDao uDao;
    //Se declara el DataSource del POOL que recibirá el dao.
    @Resource(name = "jdbc/pool")
    private DataSource poolConn;

    //CREAMOS EL MÉTODO INIT. Heredado de GerenicServlet
    @Override
    public void init()
            throws ServletException {
        super.init();

        //Inicializamos el Dao y le pasamos la conexion
        try {
            uDao = new UsuarioDao(poolConn);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        System.out.println("ENTRA AL CONTROLLER INICIO");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //LEER INSTRUCCIÓN QUE LLEGA DESDE JSP 
        String instruccion = request.getParameter("instruccion");

        //EJECUTAR LISTADO SI LA INSTRUCCIÓN ADD ES NULL
        if (instruccion == null) {
            instruccion = "listarUsers";
        }

        System.out.println("INSTRUCCION : " + instruccion);
        //SELECTOR DE EJECUCIÓN
        switch (instruccion) {
            case "listarUsers":
                System.out.println("VA AL LISTADO");
                getUsers(request, response);
                break;
            case "addUser":
                System.out.println("VA AL ADD");
                AddUsers(request, response);
                break;
            case "AVistaUpdate":
                System.out.println("VA A LA VISTAUPDATE UPDATE");

                try {
                    cargaUserToUpdate(request, response);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            case "updateUserBBDD":
                System.out.println("ENTRA EN UPDATE");
                 {
                    try {
                        updateUser(request, response);
                    } catch (Exception ex) {
                        Logger.getLogger(ControllerUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            default:
                getUsers(request, response);
        }

    }

    private void getUsers(HttpServletRequest request, HttpServletResponse response) {
        //Creamos una lista donde capturar los Usuarios recibidos por el dao
        List<Usuarios> usuarios;

        //Realizamos la consulta a través del método getUsuairos del dao
        try {

            //Igualamos la lista a la que devuelva el dao
            usuarios = uDao.getUsuarios();
            /**
             * Agregamos la lista al request para poder pasarla a la vista. Es
             * importante recordar que el nombre que le damos , será el nombre
             * con el que lo identificaremos en la vista
             */
            request.setAttribute("listaUsuarios", usuarios);

            //Por último , enviamos el listado a la vista(JSP)
            RequestDispatcher miDispatcher = request.getRequestDispatcher("/VistaUsuariosList.jsp");
            miDispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void AddUsers(HttpServletRequest request, HttpServletResponse response) {

        //CAPTURA LOS ATRIBUTOS QUE NOS LLEGAN DESDE EL FORM DE addUser.jsp
        String nickU = request.getParameter("nickForm");
        String nombreU = request.getParameter("nombreForm");
        String emailU = request.getParameter("emailForm");
        String passU = request.getParameter("passForm");

        //CREA UN USUARIO TEMPORAL
        Usuarios uTemp = new Usuarios(nickU, nombreU, emailU, passU);
        System.out.println(uTemp);

        //ADD DEL USER EN LA BBDD
        uDao.addUser(uTemp);

        //DIRIGE DE NUEVO AL LISTADO UNA VEZ AÑADIDO
        getUsers(request, response);

    }

    private void cargaUserToUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("ENTRA EN CARGA USERS");

        //Se captura del id recibido del listado
        Integer id = Integer.parseInt(request.getParameter("idUserLink"));
        System.out.println("ID : " + id);
        //Envía al DAO de usuarios el ID , y recibe todos los datos del usuario
        Usuarios uLocal = uDao.FindById(id);
        //Coloca atributo correspondiente al Id
        request.setAttribute("usuarioActualizar", uLocal);
        //Se traslada al Jsp de actualizacion con la info
        RequestDispatcher dis = request.getRequestDispatcher("/VistaUpdateUser.jsp");
        dis.forward(request, response);

    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //CAPTURA LOS ATRIBUTOS QUE NOS LLEGAN DESDE EL FORM DE addUser.jsp
        Integer idU = Integer.parseInt(request.getParameter("idUserForm"));
        String nickU = request.getParameter("nickForm");
        String nombreU = request.getParameter("nombreForm");
        String emailU = request.getParameter("emailForm");
        String passU = request.getParameter("passForm");

        //CREA UN USUARIO TEMPORAL
        Usuarios uTemp = new Usuarios(idU,nickU, nombreU, emailU, passU);
        System.out.println(uTemp);
        
        //UPDATE DEL USER EN LA BBDD
        uDao.updateUser(uTemp);

        //DIRIGE DE NUEVO AL LISTADO UNA VEZ AÑADIDO
        getUsers(request, response);
        
        
    }

}
