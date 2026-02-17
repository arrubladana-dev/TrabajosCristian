package HashMap;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Ejemplo1 {
    public static void main(String[] args) {

        HashMap<String, Integer> productos = new HashMap<>();

        boolean deseaContinuar = true;
        while (deseaContinuar) {
            String clave = (JOptionPane.showInputDialog("el producto "));
            int valor = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de producto"));
            productos.put(clave, valor);

            int numer = Integer.parseInt(JOptionPane.showInputDialog("digite 1 sidesea ingresar mas datos y culaquier otronumero sideea sdalir"));
            if (numer!=1) {
                deseaContinuar = false;
            }
        }
        System.out.println("Inventario actual:");
        for (String pro : productos.keySet()) {
            System.out.println("producto "+ pro + " cantidad "+ productos.get(pro));
            
        }
    }
}
