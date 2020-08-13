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
public class PelucheRomantico extends Peluche {
    Tocasion festividad;

    public PelucheRomantico() {
    }

    public PelucheRomantico(Tocasion festividad, Tpeluche tipoPeluche, String nombre, float tamano, float precio) {
        super(tipoPeluche, nombre, tamano, precio);
        this.festividad = festividad;
    }

    



    public Tocasion getFestividad() {
        return festividad;
    }

    public void setFestividad(Tocasion festividad) {
        this.festividad = festividad;
    }

    @Override
    public String toString() {
        return super.toString() + "," + festividad;
    }

    
    
}
