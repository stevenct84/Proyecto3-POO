/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyeto3.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static javax.swing.SpringLayout.HEIGHT;
import proyecto3.modelo.Peluche;
import proyecto3.modelo.PelucheInfantil;
import proyecto3.modelo.Tpeluche;
import proyecto3.modelo.Tusuario;
import proyecto3.modelo.Usuario;
import proyecto3.vista.VentanaAdministrarPeluches;
import proyecto3.vista.VentanaLogIn;

/**
 *
 * @author Jonathan Camacho
 */
public class Controlador{
    private static Controlador instancia;
    VentanaLogIn ventana;
    VentanaAdministrarPeluches ventanaPeluches;
    AdministradorUsuario admin= new AdministradorUsuario();
    
    public static Controlador getInstancia(VentanaLogIn ventana, VentanaAdministrarPeluches ventanaPeluches){
        if(instancia == null) {
            instancia = new Controlador(ventana, ventanaPeluches);
	}
            return instancia;
    }
    
    private Controlador(VentanaLogIn ventana, VentanaAdministrarPeluches ventanaPeluches) {
        this.ventana = ventana;
        this.ventanaPeluches = ventanaPeluches;
        _unit_();
    }
    
    
    
    public void _unit_(){
        ventana.jButtonConectarse.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) { 
                String correo = ventana.jTextNombreUsuario.getText();
                String contrasena = ventana.jFieldContraseña.getText();
                if (ventana.jComboBoxIngreso.getSelectedIndex() == 2) {
                    if (admin.conectar(Tusuario.Cliente, correo, contrasena) == false) {
                        JOptionPane.showMessageDialog(ventana, "Error al introducir su correo o contraseña", "Error", 0);
                    } else {
                        System.out.println("se abre la tienda Cliente");
                        //se abre la venta de tienda 
                    }
                } else if (admin.conectar(Tusuario.Administrador, correo, contrasena) == false) {
                    JOptionPane.showMessageDialog(ventana, "Error al introducir su correo o contraseña", "Error", 0);
                } else {
                    //se abre la tienda
                }
            }
        });
        ventana.jButtonRegistro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario();
                boolean contieneNumero = false;
                String nombre = ventana.jTextRegistroNombre.getText();
                String apellido = ventana.jTextRegistroApellido.getText();
                if (nombre.equals("") || apellido.equals("")) {
                    JOptionPane.showMessageDialog(ventana, "Debe ingresar su nombre y apellido", "Error", 0);
                    return;
                }
                if (contieneNumero == false) {
                    for (char ch : nombre.toCharArray()) {
                        if (!Character.isLetter(ch)) {
                            JOptionPane.showMessageDialog(ventana, "No puede ingresar numeros en su nombre", "Error", 0);
                            return;
                        }
                    }
                    for (char ch : apellido.toCharArray()) {
                        if (!Character.isLetter(ch)) {
                            JOptionPane.showMessageDialog(ventana, "No puede ingresar numeros en su apellido", "Error", 0);
                            return;
                        }
                    }
                }
                usuario.setNombre(nombre + " " + apellido);

                String correo = ventana.jTextRegistroCorreo.getText();
                if (correo.equals("")) {
                    JOptionPane.showMessageDialog(ventana, "Debe ingresar su correo", "Error", 0);
                    return;
                } else if (!correo.contains("@gmail.com")) {
                    JOptionPane.showMessageDialog(ventana, "Error al ingresar su correo\n" + "Debe ser @gmail.com", "Error", 0);
                    return;
                }
                usuario.setCorreo(correo);

                String contrasena = ventana.jFieldRegistroContraseña.getText();
                String confirmarContrasena = ventana.jFieldConfirmarContraseña.getText();
                if (contrasena.equals("")) {
                    JOptionPane.showMessageDialog(ventana, "Debe ingresar su contraseña", "Error", 0);
                    return;
                }
                if (confirmarContrasena.equals("")) {
                    JOptionPane.showMessageDialog(ventana, "Debe volver a ingresar su contraseña", "Error en Confirmar Contraseña", 0);
                    return;
                }
                if (contrasena.length() < 7) {
                    JOptionPane.showMessageDialog(ventana, "La contraseña debe tener minimo 8 caracteres", "Error", 0);
                    ventana.jFieldRegistroContraseña.setText("");
                    ventana.jFieldConfirmarContraseña.setText("");
                    return;
                }
                if (!contrasena.equals(confirmarContrasena)) {
                    JOptionPane.showMessageDialog(ventana, "La contraseña y la confirmación debe ser la misma", "Error", 0);
                    return;
                }
                usuario.setContrasena(contrasena);

                if (ventana.jComboBoxRegisto.getSelectedItem().equals(" ")) {
                    JOptionPane.showMessageDialog(ventana, "Debe selecionar que tipo un usuario", "Error", 0);
                    return;
                } else if (ventana.jComboBoxRegisto.getSelectedIndex() == 1) {
                    //codigo verificar si puede ser admin
                    String codigo = JOptionPane.showInputDialog("Inserte su código de empleado:");
                    if (codigo == " " || codigo == null) {
                        JOptionPane.showMessageDialog(ventana, "No puede ser administrador", "Error", 0);
                        return;
                    }
                    usuario.setUsuario(Tusuario.Administrador);
                } else {
                    usuario.setUsuario(Tusuario.Cliente);
                }

                if (admin.verificar(usuario) == false) {
                    admin.agregarUsuario(usuario);
                    JOptionPane.showMessageDialog(ventana, "Ha creado su cuenta con exito\n" + "Para ingresar a la tienda, inicie sesión", "Cuenta creada", JOptionPane.PLAIN_MESSAGE);
                    ventana.jTextRegistroNombre.setText("");
                    ventana.jTextRegistroApellido.setText("");
                    ventana.jTextRegistroCorreo.setText("");
                    ventana.jFieldRegistroContraseña.setText("");
                    ventana.jFieldConfirmarContraseña.setText("");
                } else {
                    JOptionPane.showMessageDialog(ventana, "El usuario ya esta registrado", "Error", 0);
                    return;
                }
            }
        });

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                try {
                    admin.guardarTxt();
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }

        });
        
        ventanaPeluches.jButtonRegistrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Inventario inventario = new Inventario();
                String nombre = ventanaPeluches.jTextNombre.getText();
                float precio = Float.parseFloat(ventanaPeluches.jTextPrecio.getText());
                int tamano = Integer.parseInt(ventanaPeluches.jTextTamano.getText());
                if (ventanaPeluches.jComboTipoPeluche.getSelectedItem().equals("Infantil")) {
                    PelucheInfantil peluche = new PelucheInfantil();
                    peluche.setNombre(nombre);
                    peluche.setTipoPeluche(Tpeluche.Infantil);
                    peluche.setTamano(tamano);
                    peluche.setPrecio(precio);
                    peluche.setEdadNino(Integer.parseInt(ventanaPeluches.jTextEdad.getText()));
                    System.out.println("4444444");
                    inventario.agregar("Infantil", peluche);
                }

            }
        });
    }
    

    
    public void cargarArchivos(){
        try {
            admin.cargarTxt();
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
}
    
    
    

