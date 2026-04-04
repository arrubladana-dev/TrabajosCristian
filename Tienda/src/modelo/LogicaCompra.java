package modelo;

import controlador.Coordinador;

public class LogicaCompra {
	
	private Coordinador miCoodinador;
	
	 public double calcularDescuento(double total, String tipo) {

	        double descuento = 0;

	        switch (tipo) {
	            case "a":
	                descuento = total * 0.4;
	                break;
	            case "b":
	                descuento = total * 0.2;
	                break;
	            case "c":
	                descuento = total * 0.1;
	                break;
	            default:
	                descuento = 0;
	        }

	        return descuento;
	    }

	    public double calcularTotalPagar(double total, double descuento) {
	        return total - descuento;
	    }
	    public double calcularTotal(double total, int cantidad) {
	        return total * cantidad;
	    }

		public void setCoordinador(Coordinador miCoodinador) {
			this.miCoodinador = miCoodinador;
		}
}
