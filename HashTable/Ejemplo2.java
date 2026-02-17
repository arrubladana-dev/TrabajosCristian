package HashTable;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejemplo2 {
    public static void main(String[] args) {
        Hashtable<Integer, String> productos = new Hashtable<>();

        productos.put(1234, "Cafe");
        productos.put(5432, "Panela");
        productos.put(8844, "Leche");
        productos.put(6789, "Galletas");
        productos.put(9887, "Queso");
        productos.put(8844, "Leche");

        for (String producto : productos.values()) {

            int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id que quiere validar: "));
            
            if(productos.containsKey(numero)){
                System.out.println("el producto existe");
            }else{
                System.out.println("El produto no existe");
            }

            
        }
        System.out.println("El mumero de productos en total son; "+productos.size());
        System.out.println(productos.containsKey(8844)); 
        
    }
}