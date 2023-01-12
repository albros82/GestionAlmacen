/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ComprobarLogin;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import gestionalmacen.GestionAlmacen;
import gestionalmacen.GestionAlmacen;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Usuario;

/**
 *
 * @author Albert
 */
public class LoginController implements Initializable {
    
    Usuario user = null;
    GestionAlmacen gestion = null;
    
    @FXML
    private TextField txtUsuario, txtContrasena;
    
    @FXML
    private void entrar(ActionEvent event) {
        
        ComprobarLogin cl = new ComprobarLogin(txtUsuario.getText(), txtContrasena.getText());
        
        if(cl.comprobarUsuario()==0){
            user = new Usuario(txtUsuario.getText(), txtContrasena.getText()); 
            gestion = new GestionAlmacen();
            try {
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                
                gestion.lanzarVentana(stage);
                
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }else if (cl.comprobarUsuario()==1){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("El usuario o contraseña son erroneos");
            alerta.setTitle("Error de login");
            alerta.show();
        }else if (cl.comprobarUsuario()==2){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Ha ocurrido un fallo en la conexión con la base de datos");
            alerta.setTitle("Error de conexión");
            alerta.show();
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
