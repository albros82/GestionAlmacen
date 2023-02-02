/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.scene.control.Alert;

/**
 *
 * @author Albert
 */
public class Alerta {
    
    public void getMostrarAlerta(String titulo, String cuerpo, Alert.AlertType tipo){
        
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setContentText(cuerpo);
        alerta.show();
    }
    
}
