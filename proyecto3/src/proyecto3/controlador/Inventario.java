/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyeto3.controlador;

import java.util.ArrayList;
import proyecto3.modelo.Peluche;
import proyecto3.modelo.PelucheColeccion;
import proyecto3.modelo.Tconexion;
import proyecto3.modelo.Tpeluche;


/**
 *
 * @author Jonathan Camacho
 */
public class Inventario {
    //PelucheConexion peluche=new PelucheConexion();
    ArrayList<Peluche> inventario=new ArrayList();

    public Inventario() {
    }
    
    public Peluche seleccion(String tipoPeluche){
       PelucheConexion fabrica = new PelucheConexion();
       Peluche clase=fabrica.getConexion(tipoPeluche);
       return clase;
    }
        
    
    
     
   public void agregar(String tipoPeluche, Peluche peluche){
       System.out.println("4444444444");
       System.out.println(peluche.toString());
       
       inventario.add(peluche);
       for(int i=0; i<inventario.size(); i++){
            System.out.println("Usuario agregado al array");
            System.out.println(inventario.get(i).toString());
         }
   }
    
    
}
