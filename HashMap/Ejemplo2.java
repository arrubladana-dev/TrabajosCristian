package HashMap;

import java.util.HashMap;

import javax.swing.JOptionPane;

public class Ejemplo2 {
    public static void main(String[] args) {

        HashMap<Integer, String> estudiantes = new HashMap<>();

        estudiantes.put(123, "Pepito");
        estudiantes.put(456, "Juanito");
        estudiantes.put(678, "Juanita");
        estudiantes.put(890, "Pepe");
        estudiantes.put(888, "Gojo");

        for (int estu : estudiantes.keySet()) {
            int numer = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id del destudiante que quiere validad"));

            if (estudiantes.containsKey(numer)) {
            System.out.println("El estudiante  es: " + estudiantes.get(numer));
            JOptionPane.showMessageDialog(null, "Se encntro el estudiante"+estudiantes.get(numer));
        }else{
            System.out.println("El estudiante no existe");
            JOptionPane.showMessageDialog(null, "El estudiante no existe");
        }
        }


        System.out.println("Total estudiantes: " + estudiantes.size());
    }
}
