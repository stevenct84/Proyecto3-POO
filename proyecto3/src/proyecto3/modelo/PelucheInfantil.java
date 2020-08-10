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
    Tconexion conexion;//
    int edadNino;

    public PelucheInfantil() {
    }

    
    
    

    public PelucheInfantil(Tconexion conexion, int edadNino, String nombre, float tamano) {
        super(nombre, tamano);
        this.conexion = conexion;
        this.edadNino = edadNino;
    }
    
    
    
}
