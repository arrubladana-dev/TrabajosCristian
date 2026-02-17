package HashMap;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Ejemplo3 {
    public static void main(String[] args) {

        HashMap<String, Integer> agenda = new HashMap<>();

        agenda.put("Pepito", 3001234);
        agenda.put("Juanita",  310983);
        agenda.put("Pepe", 3204567);
        agenda.put("Carla", 315678);

        String id = (JOptionPane.showInputDialog("Ingrese el ID del contacto que desea buscar"));

        if (agenda.containsKey(id)) {

            System.out.println("Contacto encontrado: " + agenda.get(id));
            JOptionPane.showMessageDialog(null,
                    "Se encontró el contacto:\n" + agenda.get(id));

        } else {

            System.out.println("El contacto no existe");
            JOptionPane.showMessageDialog(null,"El contacto no existe");

        }

        System.out.println("Total contactos: " + agenda.size());
    }
}
