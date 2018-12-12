/**
 * Este Modelo recibirá un DataSource para cominucar con BBDD
 */
package com.fernandoceballos.J2EEGIT.Dao;

import com.fernandoceballos.J2EEGIT.Entity.Usuarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import javax.sql.DataSource;

/**
 *
 * @author Fernando ceballos <fernandoceballos1989@gmail.com>
 */
public class UsuarioDao {

    //Se declara el DataSource
    private DataSource datos;

    //Recibirá en el constructor el origen de datos
    public UsuarioDao(DataSource datos) {
        this.datos = datos;
    }

    //AQUÍ COMIENZA EL CRUD
    /**
     * El método GetUsuarios ataca a la BBDD con la sentencia SELECT. Es por lo
     * tanto un método para capturar el listado en BBDD. No recibe parámetros.
     *
     * @return : List<Usuarios> en BBDD.
     */
    public List<Usuarios> getUsuarios() throws SQLException {

        //Instancia un array en el que guardar los registros.
        List<Usuarios> usuarios = new ArrayList<>();
        //Instancia de la sentencia SQL que lanzaremos a la BBDD.
        String sql = "SELECT * FROM usuario";

        //Instancia la conexion , StateMent y ResultSet a null;
        Connection miConn = null;
        Statement miStatement = null;
        ResultSet miResultSet = null;

        /**
         * Ahora se establece la conexion. Para ello se iguala la variable local
         * miConn , con el Datasource que recibe la clase en el constructor.
         * Además se inicializa el Statement.
         */
        miConn = datos.getConnection();
        miStatement = miConn.createStatement();
        //Por último , se ejecuta la query

        miResultSet = miStatement.executeQuery(sql);

        /**
         * AHORA , CAPTURAREMOS LOS REGISTROS QUE RECIBAMOS DE BBDD, PARA ELLO
         * RECORREMOS EL RESULTSET , IDENTIFICAMOS LOS CAMPOS , Y LOS AÑADIMOS A
         * LA COLECCION List<Usuario>
         */
        while (miResultSet.next()) {
            //se puede acceder desde el indice del campo , o desde su nombre
            Integer idUser = miResultSet.getInt("id_usuario");
            String nickUser = miResultSet.getString("nick_usuario");
            String nombreUser = miResultSet.getString("nombre_usuario");
            String emailUser = miResultSet.getString("email_usuario");
            String passwdUser = miResultSet.getString("passwd_usuario");

            //Se crea un Usuario temporal , para añadir a la colección a cada
            //vuelta de bucle
            Usuarios temp = new Usuarios(idUser, nickUser, nombreUser, emailUser, passwdUser);
            usuarios.add(temp);

        }

        //Finalmente , devolvemos el listado con todos los registros
        return usuarios;
    }

    public void addUser(Usuarios uTemp) {

        //INSTANCIA DE LA CONEXION
        Connection miConn = null;
        PreparedStatement stAdd = null;
        //LA CONSULTA
        String consulta = "INSERT INTO usuario(nick_usuario,nombre_usuario,email_usuario,passwd_usuario) VALUES(?,?,?,?)";

        try {
            //Se establece la conexion
            miConn = datos.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //se pasa la consulta al statement

        try {
            stAdd = miConn.prepareStatement(consulta);
            System.out.println(stAdd);
            //DAMOS VALORES AL STATEMENT
            stAdd.setString(1, uTemp.getNickUser());
            stAdd.setString(2, uTemp.getNombreUser());
            stAdd.setString(3, uTemp.getEmailUser());
            stAdd.setString(4, uTemp.getPassUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //EJECUTAMOS
        try {
            stAdd.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
