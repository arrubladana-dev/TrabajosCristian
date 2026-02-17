

import java.util.HashMap;

public class SegundoEjemplo {
    public static void main(String[] args) {
    
    HashMap<Integer, String> productos = new HashMap<Integer, String>();

    
    productos.put(123, "Jabon");
    productos.put(1234, "Leche");
    productos.put(234, "Lapiz");
    productos.put(321, "Borrador");
    System.out.println(productos);
    System.out.println(productos.get(1234));
    }

}
