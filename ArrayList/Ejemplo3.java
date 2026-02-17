package ArrayList;

import java.util.ArrayList;

public class Ejemplo3 {
    public static void main(String[] args) {
        ArrayList<String> productos = new ArrayList<String>();
        productos.add("Limpido");
            productos.add("Detergente");
            productos.add("Jabon");
            productos.add("Limpiapisos");
            productos.add("chorizo");
        

        System.out.println(productos.get(3));
        
        System.out.println("Lista de productos cambiado");
        productos.remove("chorizo");

        for (String listaEstu : productos) {
            
            System.out.println(listaEstu);
        }  
    }
}
