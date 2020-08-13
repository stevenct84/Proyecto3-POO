/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.vista;

import proyeto3.controlador.AdministradorUsuario;
import proyeto3.controlador.Controlador;

/**
 *
 * @author Jonathan Camacho
 */
public class Carga {
    public static void main(String[] args) {
        VentanaCarga ventana = new VentanaCarga();
        VentanaLogIn sign = new VentanaLogIn();
        VentanaAdministrarPeluches admiPeluches=new VentanaAdministrarPeluches();
        //ventana.setVisible(true);
        admiPeluches.setVisible(true);
        Controlador controlador = Controlador.getInstancia(sign,admiPeluches);
        controlador.cargarArchivos();
      
        /*try {
            for (int row = 0; row <= 100; row++) {
                Thread.sleep(10);
                ventana.jLabelNumeroCarga.setText(Integer.toString(row) + "%");
                ventana.jBarraCarga.setValue(row);
                if (row == 100) {
                    ventana.setVisible(false);
                    sign.setVisible(true);
                }
            }
        } catch (Exception e) {
        }*/
    }

}
