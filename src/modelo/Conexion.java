/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Albert
 */
public class Conexion {
    
    private ArchivoUsuario au = null;
    private Connection con = null;
    private String[] login = null;
    
    public Connection getConexion() throws ClassNotFoundException, IOException, SQLException{
        
        au = new ArchivoUsuario();
        
        login = au.getArchivoUsuario();
        
        Class.forName("com.mysql.jdbc.Driver");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost/GestionAlmacen", login[0], login[1]);
        
        return con;
    }
    
}
