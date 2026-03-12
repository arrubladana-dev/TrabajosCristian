package entidades;

public class Operario {
	
	private String nombre;
	private int id;
	private double salario;
	private int añosAntiguedad;
	
	public Operario() {
		
	}
	
	public Operario(String nombre, int id, double salario, int añosAntiguedad) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.salario = salario;
		this.añosAntiguedad = añosAntiguedad;
	}
	/// metodos get y set

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getAñosAntiguedad() {
		return añosAntiguedad;
	}

	public void setAñosAntiguedad(int añosAntiguedad) {
		this.añosAntiguedad = añosAntiguedad;
	}
	
	
	
	

}
