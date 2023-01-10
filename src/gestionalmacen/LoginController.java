/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalmacen;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Albert
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField txtUsuario, txtContrasena;
    
    @FXML
    private void entrar(ActionEvent event) {
        
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/GestionAlmacen", txtUsuario.getText(), txtContrasena.getText());
            System.out.println("Conexion establecida");
                    
        } catch (SQLException ex) {
            Alert alertaUsuario = new Alert(Alert.AlertType.ERROR);
            alertaUsuario.setTitle("Usuario o contraseña invalidos");
            alertaUsuario.show();
            System.out.println("Conexion Denegada");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    @FXML
    private void salir(ActionEvent event){
        
        System.exit(0);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
