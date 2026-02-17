package ArrayList;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ejemplo2 {
    public static void main(String[] args) {
        ArrayList<String> estudiantes = new ArrayList<String>();
        estudiantes.add("Juanito");
            estudiantes.add("Juanita");
            estudiantes.add("Pepito");
            estudiantes.add("Marta");
            estudiantes.add("Daniel");
        

        System.out.println(estudiantes.get(3));
        estudiantes.set(3, "Camila");
        System.out.println("Lista de estudiantes cambiado");

        for (String listaEstu : estudiantes) {
            System.out.println(listaEstu);
        }
    }
}
