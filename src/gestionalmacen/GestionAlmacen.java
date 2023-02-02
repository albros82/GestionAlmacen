/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionalmacen;

import controlador.VentanaPrincipalController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Albert
 */
public class GestionAlmacen extends Application {
    
      
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/vista/Login.fxml"));
        
        Scene login = new Scene(root);
        
        stage.setScene(login);
        stage.setResizable(false);
        stage.show();
        
        
    }   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void lanzarVentana(Stage stage) throws Exception{
        
        Stage ventanaPrincipal = new Stage();
        
        Scene escena = new Scene(FXMLLoader.load(getClass().getResource("VentanaPrincipal.fxml")));
        
        ventanaPrincipal.setScene(escena);        
        ventanaPrincipal.show();       
        
        stage.close();
    }
    
}
