package ArrayList;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ejemplo1 {
    public static void main(String[] args) {
        ArrayList<String> estudiantes = new ArrayList<String>();
        
        boolean deseaContinuar = true;
        while (deseaContinuar) {
            System.out.println("ingrese estudiantes");
            String x = (JOptionPane.showInputDialog("ingrese estu "));
            estudiantes.add(x);

            int numer = Integer.parseInt(JOptionPane.showInputDialog("digite 1 sidesea ingresar mas datos y culaquier otronumero sideea sdalir"));
            if (numer!=1) {
                deseaContinuar = false;
            }
        }
    }
}
