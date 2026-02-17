import java.util.HashSet;

public class TercerEjemplo {

    public static void main(String[] args) {
    HashSet<String> comida = new HashSet<String>();
    comida.add("salcipapa");
    comida.add("hamburguesa");
    comida.add("empanada");
    comida.add("carne");  
    comida.add("empanada");
    System.out.println(comida);
    }
}