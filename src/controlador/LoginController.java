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
import modelo.ArchivoUsuario;
import modelo.Usuario;
import vista.Alerta;

/**
 *
 * @author Albert
 */
public class LoginController implements Initializable {
    
    
    private GestionVentanas ventana = null;    
    private VentanaPrincipalController vpc = null;
    private ArchivoUsuario au = null;
    private Alerta alerta = new Alerta();
    
    
    @FXML
    private TextField txtUsuario, txtContrasena;
    
    @FXML
    private void entrar(ActionEvent event) {
        
        ComprobarLogin cl = new ComprobarLogin(txtUsuario.getText(), txtContrasena.getText());
        String[] resultado = cl.comprobarUsuario();
        
        switch (resultado[0]) {
            case "0":
                ventana = new GestionVentanas();
                try {
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();               
                    
                    au = new ArchivoUsuario();
                    au.setArchivoUsuario(txtUsuario.getText(), txtContrasena.getText());
                    
                    ventana.getVentanaPrincipal(stage);
                    
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            case "1":
                {
                    alerta.getMostrarAlerta("Error de login", "El usuario o contraseña son erroneos", Alert.AlertType.ERROR);                    
                    break;
                }
            case "2":
                {
                    alerta.getMostrarAlerta("Error de conexión", "Ha ocurrido un fallo en la conexión con la base de datos", Alert.AlertType.ERROR);                       
                    break;
                }
            default:
                break;
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
