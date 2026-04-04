package modelo.dto;

public class ProductosDTO {
	
	private String codigo;
	private String nombreProducto;
	private double precio;
	private int cantidad;
	
	// contructore 
	public ProductosDTO() {}
	public ProductosDTO(String codigo, String nombreProducto, double precio, int cantidad) {
		this.codigo = codigo;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	// set y get
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Productos [codigo: " + codigo + ", nombreProducto: " + nombreProducto + ", precio: " + precio
				+ ", cantidad: " + cantidad + "]";
	}
	
	
	
	
	

}
