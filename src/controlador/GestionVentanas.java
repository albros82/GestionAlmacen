/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Usuario;

/**
 *
 * @author Albert
 */
public class GestionVentanas {
    
    public void getVentanaPrincipal(Stage stage) throws IOException{        
               
        Scene escena = new Scene(FXMLLoader.load(getClass().getResource("/vista/VentanaPrincipal.fxml")));
        
        stage.setScene(escena);        
        stage.show();           
    }
    
    public void getCerrarVentanas(ActionEvent event){
        
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow(); 
        stage.close();
        
    }
    
    public void getAbrirVentanas(String vista) throws IOException{
        
        Stage stage = new Stage();
        
        Scene ventana = new Scene(FXMLLoader.load(getClass().getResource(vista)));
        
        stage.setScene(ventana);
        stage.showAndWait();
        
    }
    
}
