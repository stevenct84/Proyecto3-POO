/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.modelo;

/**
 *
 * @author Jonathan Camacho
 */
public class Usuario {
    Tusuario usuario;
    String nombre;
    String contrasena;

    public Usuario() {
    } 
    
    public Usuario(Tusuario usuario, String nombre, String contrasena) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public Tusuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Tusuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
