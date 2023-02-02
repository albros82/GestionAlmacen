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
    
    public ComprobarLogin(){
        
    }
              
    public String[] comprobarUsuario(){          
        
        String[] resultado = new String[4];
        
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/GestionAlmacen", usuario, contrasena);       
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from usuario where nomUsuario='" + usuario  + "' and contrasena='"+contrasena+"';");
            
            
            if(rs.next()){
                resultado[0]="0";            
                resultado[1]=rs.getString("nomUsuario");
                resultado[2]=rs.getString("contrasena");
                resultado[3]=rs.getString("permiso");
            }
            con.close();
                    
        } catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException e){
            resultado[0]="2";
            return resultado;
        
        }catch (SQLException ex) {
            //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            resultado[0]="1";
            return resultado;
        }catch (ClassNotFoundException ex) {
            //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            
        }       
        
        return resultado;
        
    }
    
}
