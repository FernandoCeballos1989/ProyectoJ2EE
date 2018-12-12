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

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Creamos una lista donde capturar los Usuarios recibidos por el dao
        List<Usuarios> usuarios;
        
        //Realizamos la consulta a través del método getUsuairos del dao
        try {
            
            //Igualamos la lista a la que devuelva el dao
            usuarios= uDao.getUsuarios();
            /**
             * Agregamos la lista al request para poder pasarla a la vista.
             * Es importante recordar que el nombre que le damos , será el 
             * nombre con el que lo identificaremos en la vista
             */
            request.setAttribute("listaUsuarios", usuarios);
            
            //Por último , enviamos el listado a la vista(JSP)
            RequestDispatcher miDispatcher = request.getRequestDispatcher("/VistaUsuariosList.jsp");
            miDispatcher.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
