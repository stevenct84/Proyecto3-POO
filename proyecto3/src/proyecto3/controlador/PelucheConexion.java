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
    public Peluche getConexion(String categoria){
        Peluche eleccion=null;
        if("Infantil".equals(categoria))
            eleccion=new PelucheInfantil();
        if("Romantico".equals(categoria))
            eleccion=new PelucheRomantico();
        if("Coleccion".equals(categoria))
            eleccion = new PelucheColeccion();
        
        return eleccion;
    }
}
