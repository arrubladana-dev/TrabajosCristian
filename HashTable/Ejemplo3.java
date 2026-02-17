package HashTable;

import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejemplo3 {
    public static void main(String[] args) {
        Hashtable<Integer, String> productos = new Hashtable<>();

        productos.put(1234, "Cafe");
        productos.put(5432, "Panela");
        productos.put(8844, "Leche");
        productos.put(6789, "Galletas");
        productos.put(9887, "Queso");
        productos.put(8844, "Leche");

        boolean deseaContiniar = true;

        while(deseaContiniar){
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("digite 1 sidesea eliminar productos o 2 sib quiere vaciar todo"));

            if (opcion ==1) {
                int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del producto que quiere eliminar "));
            if (productos.containsKey(numero)) {
                    productos.remove(numero);
                    System.out.println("Producto eliminado correctamente.");
                    JOptionPane.showMessageDialog(null, "Producto eliminado correctamente", null, 0);
                } else {
                    System.out.println("El producto no existe.");
                    JOptionPane.showMessageDialog(null, "no existe", null, 0);
                }
            }else{
                productos.clear();
                System.out.println("Todos los prodtos fueron eliminados.");
            }
            
                int numer = Integer.parseInt(JOptionPane.showInputDialog("digite 1 sidesea ingresar mas datos y culaquier otronumero sideea sdalir"));
            if (numer!=1||productos.isEmpty()) {
                deseaContiniar = false;
            }

        }

        for (String producto : productos.values()) {

            System.out.println(producto);

            
        }
        System.out.println("El mumero de productos en total son; "+productos.size());
        System.out.println(productos.containsKey(8844)); 
        
    }
}
