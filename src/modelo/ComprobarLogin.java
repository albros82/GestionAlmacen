/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import controlador.LoginController;
import controlador.LoginController;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Albert
 */
public class ComprobarLogin {
    
    private String usuario, contrasena;
    private int conexion;
    private Connection con = null;
    
    public ComprobarLogin(String usuario, String contrasena){
        
        this.usuario = usuario;
        this.contrasena = contrasena;
        
    }
              
    public int comprobarUsuario(){          
        
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/GestionAlmacen", "root", "Fqmk5839*");       
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from usuario where nomusuario='" + usuario  + "' and contrasena=MD5('"+contrasena+"');");
            
            if (rs.next()){
                conexion=0;
            }else{
                conexion=1;
            }
            
            
                    
        } catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException e){
            conexion=2;
            return conexion;
        
        }catch (SQLException ex) {
            //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            conexion=2;
            return conexion;
        }catch (ClassNotFoundException ex) {
            //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {                
                //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                conexion=2;
                System.out.println("Error de conexion");
                return conexion; 
                
            }
        }        
        
        return conexion;
        
    }
    
}
