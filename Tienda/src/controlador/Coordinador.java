package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.LogicaCompra;
import modelo.dao.ClienteDAO;
import modelo.dao.ComprasDAO;
import modelo.dao.ProductoDAO;
import modelo.dto.ClienteDTO;
import modelo.dto.ComprasDTO;
import modelo.dto.ProductosDTO;
import vista.VentanaCompras;
import vista.VentanaConsultarProducto;
import vista.VentanaConsultarUsuario;
import vista.VentanaPrincipal;
import vista.VentanaProductos;
import vista.VentanaRegistrarProducto;
import vista.VentanaRegistrarUsuario;
import vista.VentanaUsuarios;

public class Coordinador {
	private VentanaPrincipal miVentaPrincipal;
	private VentanaCompras miVentanaCompras;
	private VentanaProductos miVentanaProductos;
	private VentanaRegistrarUsuario miVentanaRegistroUsuario;
	private VentanaUsuarios miVentanaUsuarios;
	private ClienteDAO misCliente;
	private ComprasDAO misCompra;
	private ProductoDAO misProductos;
	private VentanaRegistrarProducto miRegistroproducto;
	private VentanaConsultarUsuario miVentanaConsultarUsuarios;
	private VentanaConsultarProducto miVnetanaConsultarProducto;
	private LogicaCompra miLogicaCompras;
	
	//Metodos para llarmar las ventanas 
	public void setVentanaPrincipal(VentanaPrincipal miVentaPrincipal) {
		this.miVentaPrincipal = miVentaPrincipal;
	}

	public void setVentanaCompras(VentanaCompras miVentanaCompras) {
		this.miVentanaCompras = miVentanaCompras;
	}

	public void setVentanaProductos(VentanaProductos miVentanaProducto) {
		this.miVentanaProductos = miVentanaProducto;
	}

	public void setVentanaRegistrarUsuario(VentanaRegistrarUsuario miVentanaRegistroUsuario) {
		this.miVentanaRegistroUsuario = miVentanaRegistroUsuario;
	}

	public void setVentanaUsuario(VentanaUsuarios miVentanaUsuarios) {
		this.miVentanaUsuarios = miVentanaUsuarios;
	}

	public void setClienteDAO(ClienteDAO misCliente) {
		this.misCliente = misCliente;
	}

	public void setComprasDAO(ComprasDAO misCompra) {
		this.misCompra = misCompra;
	}

	public void setProductoDAO(ProductoDAO misProductos) {
		this.misProductos = misProductos;
	}
	public void setVentanaRegistrarProducto(VentanaRegistrarProducto miRegistroproducto) {
		this.miRegistroproducto = miRegistroproducto;
	}
	
	public void setVentanaConsultarUsuario(VentanaConsultarUsuario miVentanaConsultarUsuarios) {
		this.miVentanaConsultarUsuarios = miVentanaConsultarUsuarios;
	}
	public void setVentanaConsultarProducto(VentanaConsultarProducto miVnetanaConsultarProducto) {
		this.miVnetanaConsultarProducto = miVnetanaConsultarProducto;
	}
	public void setLogicaCompras(LogicaCompra miLogicaCompras) {
		this.miLogicaCompras = miLogicaCompras;
	}

	
	//metodos paar hacer visibles las ventanas

	public void verVentanaPrincipal() {
		miVentaPrincipal.setVisible(true);
	}

	public void mostrarVentanaUsuarios() {
		miVentanaUsuarios.setVisible(true);
		miVentaPrincipal.setVisible(false);
	}

	public void mostrarVentanaProductos() {
		miVentanaProductos.setVisible(true);
		miVentaPrincipal.setVisible(false);
	}

	public void mostrarVentanaCompras() {
		miVentanaCompras.setVisible(true);
		miVentanaCompras.cargarProductos(obtenerProductos());
		miVentaPrincipal.setVisible(false);
		
	}

	public void mostrarVentanaRegistrarProducto() {
		miRegistroproducto.setVisible(true);
	}

	public void mostrarVentanaRegistrarUsuario() {
		miVentanaRegistroUsuario.setVisible(true);
		miVentanaUsuarios.setVisible(false);
	}
	
	public void mostrarVentanaConsultarUsuarios() {
		miVentanaConsultarUsuarios.setVisible(true);
		miVentanaUsuarios.setVisible(false);
	}
	public void mostrarVentanaConsultarProductos() {
		miVnetanaConsultarProducto.setVisible(true);
		miVentanaProductos.setVisible(false);
	}
	
	
	//Metodos de logica

	public String registrarUsuario(ClienteDTO miCliente) {
		return misCliente.registrarUsuario(miCliente);
		
	}

	public String eliminarUsuario(String documento) {
		try {
			return misCliente.eliminarUsuario(documento);
		} catch (SQLException e) {
			//e.printStackTrace();
			return "error"; 
		}
	}

	public ClienteDTO consultarUsuario(String doucmento) {
		return misCliente.consultarUsuario(doucmento);
	}

	public ArrayList<ClienteDTO>  consultarlistaUsuarios() {
		try {
			return misCliente.consultarListaUsuarios();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<ClienteDTO>();
		}
	}
	//------------------------------------Actualizar---------------------------------------------------

	public String actualizarUsuarios (ClienteDTO usuario) {
		
		try {
			return misCliente.actualizarUsuarios(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error";
		}
		
		
	}
// --------------------------------------------------------PRODUCTOS-------------------------------------------------
	public String eliminarProducto(String codigo) {
		
		try {
			return misProductos.eliminarProducto(codigo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Erroe";
		}
	}

	public String registrarProducto(ProductosDTO producto) {
		
		return misProductos.registrarProducto(producto);
        	
	}

	public String actualizarProducto(ProductosDTO producto) {
		try {
			return misProductos.actualizarProducto(producto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error";
		}
	}

	public ProductosDTO consultarProducto(String cod) {
		return misProductos.consultarProducto(cod);
	}

	public ArrayList<ProductosDTO> consultarlistaProductos() {
		// TODO Auto-generated method stub
		try {
			return misProductos.consultarListaProductos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<ProductosDTO>();
		}
	}
	// -------------------------------------------DESCUENTO-----------------------------------------------------
	public double calcularDescuento(double total, String tipo) {
	    return miLogicaCompras.calcularDescuento(total, tipo);
	}

	public double calcularTotalPagar(double total, double descuento) {
	    return miLogicaCompras.calcularTotalPagar(total, descuento);
	}
	//----------------------------------------------COMPRAS------------------------------------------------------

	public void registrarCompra(ComprasDTO compra) {
		misCompra.registrarCompra(compra);
	}
	
	public ArrayList<ProductosDTO> obtenerProductos() {
	    try {
			return misProductos.consultarListaProductos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<ProductosDTO>();
		}
	}

	public double calcularTotal(double precio, int cantidad) {
		// TODO Auto-generated method stub
		return miLogicaCompras.calcularTotal(precio, cantidad);
	}

	
	

	

	



}
