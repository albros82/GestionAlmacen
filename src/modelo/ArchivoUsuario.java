/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Albert
 */
public class ArchivoUsuario {
    
    public void setArchivoUsuario(String nombre, String contrasena) throws IOException{
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("temp/datosUsuario.txt")))) {
            bw.write(nombre + " " + contrasena);
        }
        
    }
    
    public String[] getArchivoUsuario() throws IOException{
        
        String[] resultado = new String[2];
        
        BufferedReader br = new BufferedReader(new FileReader(new File("temp/datosUsuario.txt")));
        
        resultado = br.readLine().split(" ");
        
        return resultado;
        
    }
    
}
