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
public class PelucheInfantil extends Peluche{
    int edadNino;

    public PelucheInfantil() {
    }

    public PelucheInfantil(int edadNino) {
        this.edadNino = edadNino;
    }

    public PelucheInfantil(int edadNino, Tpeluche tipoPeluche, String nombre, float tamano, float precio) {
        super(tipoPeluche, nombre, tamano, precio);
        this.edadNino = edadNino;
    }

    

    public int getEdadNino() {
        return edadNino;
    }

    public void setEdadNino(int edadNino) {
        this.edadNino = edadNino;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public float getTamano() {
        return tamano;
    }

    @Override
    public void setTamano(float tamano) {
        this.tamano = tamano;
    }

    @Override
    public float getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return super.toString() + "," + edadNino;
    }        
    
    
}
