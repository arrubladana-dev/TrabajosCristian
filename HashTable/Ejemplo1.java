package HashTable;

import java.util.Hashtable;

public class Ejemplo1 {
    public static void main(String[] args) {
        Hashtable<Integer, String> empleados = new Hashtable<>();

        empleados.put(1234, "Pepito");
        empleados.put(5432, "Juanita");
        empleados.put(6789, "Marta");
        empleados.put(9887, "Patricia");
        empleados.put(8844, "Juanito");

        for (String wi : empleados.values()) {

            System.out.println(wi);
        }
        System.out.println("El mumero de empleados en total son; "+empleados.size());
        
    }
}
