package clases;

public class Procesos {
	
//	public boolean validarNota(String nota1Texto,String nota2Texto,String nota3Texto) {
//		
//		double n1=Double.parseDouble(nota1Texto);
//		double n2=Double.parseDouble(nota2Texto);
//		double n3=Double.parseDouble(nota3Texto);
//		
//		if (n1>=0 && n1 <=5 && n2>=0 && n2 <=5 && n3>=0 && n3 <=5) {
//			return true;
//		}else {
//			return false;
//		}
//		
//	}
	
	public boolean validarNota(String nota1Texto) {
		
		double n1=Double.parseDouble(nota1Texto);
		
		if (n1>=0 && n1 <=5 ) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public double calcularPromedio(double n1, double n2, double n3) {
		
		double prom=(n1+n2+n3)/3;
		
		return prom;
		
		
	}
	
	
	

}
