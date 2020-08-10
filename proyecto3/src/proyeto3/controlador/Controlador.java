/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyeto3.controlador;

/**
 *
 * @author Jonathan Camacho
 */
public class Controlador {
    private static Controlador instancia;

    public Controlador() {
    }
    
    public static Controlador getInstancia(){
        if(instancia == null) {
            instancia = new Controlador();
	}
            return instancia;
    }
    
    //aqui se agregan los metodos
}
