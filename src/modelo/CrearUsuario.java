/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import vista.Alerta;

/**
 *
 * @author Albert
 */
public class CrearUsuario {
    
    private Connection con = null;
    private String sqlTablaUsuario;
    private String sqlInsertarUsuario;
    private String sqlPermisosUsuario;
    
    public void setCrearUsuario(String nombre, String contrasena, int permiso) throws SQLException{       
        
        try {
            
            con = new Conexion().getConexion(); 
            con.setAutoCommit(false);
            
            if (permiso==1){
                sqlPermisosUsuario = ("GRANT ALL PRIVILEGES ON *.* TO '" + nombre + "'@'localhost' WITH GRANT OPTION;");
            }else{
                sqlPermisosUsuario = ("GRANT SELECT, UPDATE ON GestionAlmacen.* TO '" + nombre + "'@'localhost';");
            }
            
            sqlInsertarUsuario = ("CREATE USER '" + nombre + "'@'localhost' IDENTIFIED BY '" + contrasena + "';");
            
            sqlTablaUsuario = ("INSERT INTO usuario VALUES (?,?,?);");
            
            PreparedStatement ps = con.prepareStatement(sqlTablaUsuario);
            ps.setString(1, nombre);
            ps.setString(2, contrasena);
            ps.setInt(3, permiso);
            ps.executeUpdate();
            
            Statement st = con.createStatement();
            st.executeUpdate(sqlInsertarUsuario);          
            
            st.executeQuery(sqlPermisosUsuario);      
            st.executeQuery("FLUSH PRIVILEGES;");
            
            con.commit();
            
        }catch (MySQLIntegrityConstraintViolationException e){        
            new Alerta().getMostrarAlerta("Usuario no válido", "El usuario ya existe en la BBDD", Alert.AlertType.ERROR);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
            con.rollback();
        } catch (IOException ex) {
            Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
            con.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
            con.rollback();
        }finally{
            con.close();
        }
        
        
    }
    
}
