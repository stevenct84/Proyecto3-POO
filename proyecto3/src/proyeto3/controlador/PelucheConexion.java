/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyeto3.controlador;

import proyecto3.modelo.Peluche;
import proyecto3.modelo.PelucheColeccion;
import proyecto3.modelo.PelucheInfantil;
import proyecto3.modelo.PelucheRomantico;

/**
 *
 * @author Jonathan Camacho
 */
public class PelucheConexion {
    public Peluche getConexion(TipoPeluche categoria){
        Peluche eleccion=null;
        if(categoria.equals(TipoPeluche.Infantil))
            eleccion=new PelucheInfantil();
        if(categoria.equals(TipoPeluche.Romantico))
            eleccion=new PelucheRomantico();
        if(categoria.equals(TipoPeluche.Coleccion))
            eleccion = new PelucheColeccion();
        
        return eleccion;
    }
}
