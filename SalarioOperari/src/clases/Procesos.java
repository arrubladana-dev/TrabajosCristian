package clases;

public class Procesos {
	
//	Si el sueldo es inferior a 500 y su antigüedad es igual o superior a 10 años, otorgarle un aumento del 20%, mostrar el
//	sueldo a pagar.
//	Si el sueldo es inferior a 500 pero su antigüedad es menor a 10 años, otorgarle un aumento de 5%.
//	Si el sueldo es mayor o igual a 500 mostrar el sueldo en pantalla sin cambios.
	
	public double aumentoSalario(double salarioBase, int añosAntiguedad) {
		
		if(salarioBase<500&& añosAntiguedad>10) {
			return salarioBase = salarioBase*1.10;
		}else if(salarioBase<500&&añosAntiguedad<10) {
			return salarioBase = salarioBase*1.05;
		}
		return salarioBase;
	}
	
	public static boolean esDouble(String cadena) {
	    try {
	        Double.parseDouble(cadena);
	        return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	}
}
