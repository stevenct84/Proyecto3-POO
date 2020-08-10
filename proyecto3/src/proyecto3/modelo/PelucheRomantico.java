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

    public PelucheRomantico(Tocasion festividad, String nombre, float tamano) {
        super(nombre, tamano);
        this.festividad = festividad;
    }    
    
}
