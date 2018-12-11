/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandoceballos.J2EEGIT.Controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;

/**
 *
 * @author Fernando ceballos <fernandoceballos1989@gmail.com>
 */
public class ServletConnPrueba extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //Se declara el DataSource
    @Resource(name = "jdbc/usuario")
    private DataSource poolConn;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletConnPrueba</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletConnPrueba at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

//        Ahora haremos una prueba para verificar la lectura de BBDD y el correcto
//                funcionamiento del POOL
        
        //Instanciamos un PrintWriter
        PrintWriter salida = response.getWriter();
        //declaramos el tipo de salida como texto
        response.setContentType("text/plain");
        
        //AHORA CONECTAMOS CON BBDD
        Connection miConexion=null;
        
        Statement miStatement=null;
        
        ResultSet miResultSet=null;
   
        try {
            
            miConexion= poolConn.getConnection();
            
            String misql="SELECT * FROM usuario";
            
            miStatement= miConexion.createStatement();

            miResultSet=miStatement.executeQuery(misql);
            
            while(miResultSet.next()){
                //Resultset.getString recibe la posicion de la columna a capturar
                String nombre_usuario=miResultSet.getString(3);
            
                salida.println(nombre_usuario);
                
            }
            
        } catch (Exception e) {
        e.printStackTrace();
        }
    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
