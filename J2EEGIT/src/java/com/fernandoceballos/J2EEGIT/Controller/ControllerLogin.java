/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandoceballos.J2EEGIT.Controller;

import com.fernandoceballos.J2EEGIT.Dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "ControllerLogin", urlPatterns = {"/ControllerLogin"})
public class ControllerLogin extends HttpServlet {

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

        System.out.println("ENTRA AL CONTROLLER LOGIN");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //LEER INSTRUCCIÓN QUE LLEGA DESDE JSP 
        String instruccion = request.getParameter("instruccion");

        //EJECUTAR LOGIN SI LA INSTRUCCIÓN ADD ES NULL
        if (instruccion == null) {
            instruccion = "cargalogin";
        }

        System.out.println("INSTRUCCION : " + instruccion);
        //SELECTOR DE EJECUCIÓN

        switch (instruccion) {
            case "cargalogin":
                cargaVistaLogin(request, response);
                break;
            case "credenciales":
                
                System.out.println("ENTRA EN INSTRUCCION LOGIN USER");
        {
            try {
                login(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            break;
            default:
                cargaVistaLogin(request, response);
        }

        if (instruccion == "loginUser") {
            try {
                login(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        //CAPTURA LOS ATRIBUTOS QUE NOS LLEGAN DESDE EL FORM DE addUser.jsp
        String nombre = request.getParameter("nombreUser");
        String passwd = request.getParameter("passwdUser");

        try {
            //COMPRUEBA CREDENCIALES EN BBDD
            if (uDao.CompruebaLogin(nombre, passwd)) {
                
                System.out.println("OK LOGIN");
                //LOGIN OK- enviamos el listado a la vista(JSP)
                RequestDispatcher miDispatcher = request.getRequestDispatcher("/ControllerUsuario");
                miDispatcher.forward(request, response);
            } else {
                //LOGIN FAILED- recarga vista login(JSP)
                RequestDispatcher miDispatcher = request.getRequestDispatcher("/Login.jsp");
                miDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void cargaVistaLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher miDispatcher = request.getRequestDispatcher("/Login.jsp");
        miDispatcher.forward(request, response);
    }

}
