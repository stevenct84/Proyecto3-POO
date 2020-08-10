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
public class PelucheColeccion extends Peluche{
    Tconexion conexion;//serie o pelicula relacionada

    public PelucheColeccion() {
    }

    
    

    public PelucheColeccion(Tconexion conexion, String nombre, float tamano) {
        super(nombre, tamano);
        this.conexion = conexion;
    }
    
}
