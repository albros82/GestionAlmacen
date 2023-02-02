/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import modelo.CrearUsuario;
import vista.Alerta;

/**
 * FXML Controller class
 *
 * @author Albert
 */
public class CrearUsuarioController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtContrasena;
    @FXML
    private CheckBox cbPermiso;
    
    private int permiso = 0;    
      

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btCrear(ActionEvent event) {
        
        if (txtNombre.getText().isEmpty() || txtContrasena.getText().isEmpty()) 
            new Alerta().getMostrarAlerta("Error datos", "Deebe introducir todos los datos", Alert.AlertType.ERROR);
        else{
            
            if(cbPermiso.isSelected()) permiso = 1;
            
            try {
                
                new CrearUsuario().setCrearUsuario(txtNombre.getText(), txtContrasena.getText(), permiso);
                btCancelar(event);
                
            } catch (SQLException ex) {
                Logger.getLogger(CrearUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @FXML
    private void btCancelar(ActionEvent event) {        
        
        new GestionVentanas().getCerrarVentanas(event);
        
    }
    
}
