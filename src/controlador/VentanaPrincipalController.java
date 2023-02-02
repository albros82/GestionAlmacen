/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import modelo.ArchivoUsuario;
import modelo.ComprobarLogin;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author Albert
 */
public class VentanaPrincipalController implements Initializable {

    @FXML
    private MenuItem mCrearUsuario;
    @FXML
    private MenuItem mCrearArticulo;   
    
    GestionVentanas gv = new GestionVentanas();
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            
            ArchivoUsuario au = new ArchivoUsuario();
            
            String[] login = au.getArchivoUsuario();
            
            ComprobarLogin cl = new ComprobarLogin(login[0], login[1]);
            
            String[] usuario = cl.comprobarUsuario();
            
            mCrearArticulo.setDisable(usuario[3].equals("0"));
            mCrearUsuario.setDisable(usuario[3].equals("0"));
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void crearUsuario(ActionEvent event) {
        
        try {
            gv.getAbrirVentanas("/vista/CrearUsuario.fxml");
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void crearArticulo(ActionEvent event) {
    }

    @FXML
    private void mostrarArticulo(ActionEvent event) {
    }

    @FXML
    private void mostrarUbicacion(ActionEvent event) {
    }

    @FXML
    private void mostrarTrazabilidad(ActionEvent event) {
    }

    @FXML
    private void salir(ActionEvent event) {
    }
    
    
    
}
