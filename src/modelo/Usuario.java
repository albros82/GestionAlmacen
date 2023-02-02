/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Albert
 */
public class Usuario {
    
    private final String USUARIO;
    private final String CONTRASENA;
    private final boolean PERMISO;
    
    public Usuario(String usuario, String contrasena, boolean permiso){
        USUARIO = usuario;
        CONTRASENA = contrasena;
        PERMISO = permiso;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public String getCONTRASENA() {
        return CONTRASENA;
    }
    
    public boolean getPermiso(){
        return PERMISO;
    }
    
}
