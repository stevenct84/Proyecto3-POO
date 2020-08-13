/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyeto3.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.SpringLayout.HEIGHT;
import proyecto3.modelo.Tusuario;
import proyecto3.modelo.Usuario;
import proyecto3.vista.VentanaLogIn;

/**
 *
 * @author Jonathan Camacho
 */
public class AdministradorUsuario {
    ArrayList<Usuario> usuarios=new ArrayList();

    public AdministradorUsuario() {
    }
    
    
   public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
        for(int i=0; i<usuarios.size(); i++){
            System.out.println("Usuario agregado al array");
            System.out.println(usuarios.get(i).toString());
         }
    }
   
   public void imprimirArray(){
       for(int i=0; i<usuarios.size(); i++){
            System.out.println(usuarios.get(i).toString());
       }
   }
   
   
   
   public boolean verificar(Usuario usuario){
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCorreo().equals(usuario.getCorreo())) {
                return true;
            }
        }
        return false;
    }
   
    public boolean conectar(Tusuario tipoUsuario,String correo, String contrasena){
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getUsuario().equals(tipoUsuario)){
                if (usuarios.get(i).getCorreo().equals(correo)) {
                    if(usuarios.get(i).getContrasena().equals(contrasena))
                        return true;
                }
            }
        }
        return false;
    }
   
   public void guardarTxt() throws FileNotFoundException, IOException{
       
       File archivo=new File("AdministradorUsuarios.txt");
       archivo.delete();
       FileWriter escribir=new FileWriter(archivo,true);
        for(int i=0; i<usuarios.size(); i++){ 
            escribir.write(usuarios.get(i).toString());
        }    
        //Cerramos la conexion
        escribir.close();
        }
       
    public void cargarTxt() throws FileNotFoundException, IOException{
       try{ 
           String texto = "";
           FileReader lector = new FileReader("AdministradorUsuarios.txt");
           BufferedReader contenido = new BufferedReader(lector);
           while ((texto = contenido.readLine()) != null) {
               Usuario usuario = new Usuario();
               String partes[] = texto.split(",");
               int posicion = 0;
               for (String item : partes) {
                   if (posicion == 0 && item.equals("Cliente")) {
                       usuario.setUsuario(Tusuario.Cliente);
                       posicion++;
                       continue;
                   }
                   if (posicion == 0 && item.equals("Administrador")) {
                       usuario.setUsuario(Tusuario.Administrador);
                       posicion++;
                       continue;
                   }
                   if (posicion == 1) {
                       usuario.setNombre(item);
                       posicion++;
                       continue;
                   }
                   if (posicion == 2) {
                       usuario.setCorreo(item);
                       posicion++;
                       continue;
                   }
                   if (posicion == 3) {
                       usuario.setContrasena(item);
                       posicion++;
                       continue;
                   }
               }
               usuarios.add(usuario);
           }
       }catch(FileNotFoundException e){
           System.out.println("no esta");
               return;   
        }
       for(int i=0; i<usuarios.size(); i++){
           System.out.println("Archivo cargado");
            System.out.println(usuarios.get(i).toString());
       }
    }
}

            


    
    
    
    
    

