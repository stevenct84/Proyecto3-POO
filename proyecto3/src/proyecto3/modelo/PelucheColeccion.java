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

    public PelucheColeccion(Tconexion conexion, Tpeluche tipoPeluche, String nombre, float tamano, float precio) {
        super(tipoPeluche, nombre, tamano, precio);
        this.conexion = conexion;
    }


    public Tconexion getConexion() {
        return conexion;
    }

    public void setConexion(Tconexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public String toString() {
        return super.toString() + "," + conexion;
    }

    
    
}
