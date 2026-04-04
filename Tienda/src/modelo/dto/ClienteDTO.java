package modelo.dto;


public class ClienteDTO {

	private String documento;
	private String nombreUsuario;
	private String apellidoUsuario;
	private int edad;
	private String telefono;
	private String tipo;
	
	// contructor
	
	public ClienteDTO() {}
	

	public ClienteDTO(String documento, String nombreUsuario, String apellidoUsuario,int edad,
			String telefono, String tipo) {
	
		this.documento = documento;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.edad = edad;
		this.telefono = telefono;
		this.tipo = tipo;
	}
	
	//ste y get
	

	public String getDocumento() {
		return documento;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getApellidoUsuario() {
		return apellidoUsuario;
	}


	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "ClienteDTO [documento=" + documento + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario="
				+ apellidoUsuario + ", edad=" + edad + ", telefono=" + telefono + ", tipo=" + tipo + "]";
	}
	
	// cprdinador 
	


}