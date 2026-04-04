package modelo.dto;

public class ComprasDTO {
	private int idFacturaCodigo;
	private double descuento;
	private double compraRealizada;
	private double total;
	private String documento;
	private String codigoProducto;
	
	public ComprasDTO() {}
	
	public ComprasDTO(int idFacturaCodigo, double descuento, double compraRealizada, double total, String documento,
			String codigoProducto) {
		this.idFacturaCodigo = idFacturaCodigo;
		this.descuento = descuento;
		this.compraRealizada = compraRealizada;
		this.total = total;
		this.documento = documento;
		this.codigoProducto = codigoProducto;
	}

	public int getIdFacturaCodigo() {
		return idFacturaCodigo;
	}

	public void setIdFacturaCodigo(int idFacturaCodigo) {
		this.idFacturaCodigo = idFacturaCodigo;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getCompraRealizada() {
		return compraRealizada;
	}

	public void setCompraRealizada(double compraRealizada) {
		this.compraRealizada = compraRealizada;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	@Override
	public String toString() {
		return "Compras [idFacturaCodigo: " + idFacturaCodigo + ", descuento: " + descuento + ", compraRealizada: "
				+ compraRealizada + ", total: " + total + ", documento: " + documento + ", codigoProducto: "
				+ codigoProducto + "]";
	}
	
	
	
	
	
}
