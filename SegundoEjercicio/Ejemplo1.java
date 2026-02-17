package SegundoEjercicio;

import java.util.Arrays;

public class Ejemplo1 {
    public static void main(String[] args) {
        String[] litaestudiantes = new String[3];

        litaestudiantes[0] = "Carlos";
        litaestudiantes[1] = "Pepe";
        litaestudiantes[2] = "Paola";

        System.out.println(litaestudiantes[2]);

        // Ejemplo 2
        String[] estudiantes = { "Pepito ", "Juanita", "Juanito ", "Charlie" };

        System.out.println(Arrays.toString(estudiantes));

        // Ejemplo 3
        int[] numeroCedula = { 1234, 4321, 5678, 8765 };
        for (int cedula : numeroCedula) {
            if (cedula == 5678) {
                System.out.println("Se encontro el numero de cedula");
                break; 
            }
        }
        System.out.println("__________");
        for(int i=0; i<=numeroCedula.length; i++){
            System.out.println(numeroCedula[i]);
        }
    }

}
