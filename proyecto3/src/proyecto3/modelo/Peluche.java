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
public abstract class Peluche {
    Tpeluche tipoPeluche;
    String nombre;
    float tamano;
    float precio;

    public Peluche() {
    }

    public Peluche(Tpeluche tipoPeluche, String nombre, float tamano, float precio) {
        this.tipoPeluche = tipoPeluche;
        this.nombre = nombre;
        this.tamano = tamano;
        this.precio = precio;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTamano() {
        return tamano;
    }

    public void setTamano(float tamano) {
        this.tamano = tamano;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Tpeluche getTipoPeluche() {
        return tipoPeluche;
    }

    public void setTipoPeluche(Tpeluche tipoPeluche) {
        this.tipoPeluche = tipoPeluche;
    }

    @Override
    public String toString() {
        return tipoPeluche + "," + nombre + "," + tamano + "," + precio;
    }
    
    
    
    
    
    
    
}
