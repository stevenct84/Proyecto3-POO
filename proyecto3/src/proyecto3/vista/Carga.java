/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.vista;

/**
 *
 * @author Jonathan Camacho
 */
public class Carga {
    public static void main(String[] args) {
        VentanaCarga ventana = new VentanaCarga();
        //NewSignin sign = new NewSignin();
        ventana.setVisible(true);
        try {
            for (int row = 0; row <= 100; row++) {
                Thread.sleep(100);
                ventana.jLabelNumeroCarga.setText(Integer.toString(row) + "%");
                ventana.jBarraCarga.setValue(row);
                if (row == 100) {

                    //screen.setVisible(false);
                    //sign.setVisible(true);
                }
            }
        } catch (Exception e) {
        }
    }

}
