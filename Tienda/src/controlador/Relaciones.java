package controlador;


import modelo.LogicaCompra;
import modelo.dao.ClienteDAO;
import modelo.dao.ComprasDAO;
import modelo.dao.ProductoDAO;
import vista.VentanaCompras;
import vista.VentanaConsultarProducto;
import vista.VentanaConsultarUsuario;
import vista.VentanaPrincipal;
import vista.VentanaProductos;
import vista.VentanaRegistrarProducto;
import vista.VentanaRegistrarUsuario;
import vista.VentanaUsuarios;

public class Relaciones {
	public Relaciones() {
		
		//instancias 

		ClienteDAO misCliente = new ClienteDAO();
		ComprasDAO misCompra = new ComprasDAO();
		ProductoDAO misProductos = new ProductoDAO();
		VentanaPrincipal miVentaPrincipal = new VentanaPrincipal(); 
		VentanaCompras miVentanaCompras = new VentanaCompras();
		VentanaProductos miVentanaProductos = new VentanaProductos();
		VentanaRegistrarUsuario miVentanaRegistroUsuario = new VentanaRegistrarUsuario();
		VentanaUsuarios miVentanaUsuarios = new VentanaUsuarios();
		VentanaRegistrarProducto miRegistroproducto = new VentanaRegistrarProducto();
		VentanaConsultarUsuario miVentanaConsultarUsuarios = new VentanaConsultarUsuario();
		VentanaConsultarProducto miVnetanaConsultarProducto = new VentanaConsultarProducto();
		LogicaCompra miLogicaCompras = new LogicaCompra();
		Coordinador miCoodinador = new Coordinador();
		
		//Relaciones 
		misCliente.setCoordinador(miCoodinador);
		misCompra.setCoordinador(miCoodinador);
		misProductos.setCoordinador(miCoodinador);
		miVentaPrincipal.setCoordinador(miCoodinador);
		miVentanaCompras.setCoordinador(miCoodinador);
		miVentanaProductos.setCoordinador(miCoodinador);
		miVentanaRegistroUsuario.setCoordinador(miCoodinador);
		miVentanaUsuarios.setCoordinador(miCoodinador);
		miRegistroproducto.setCoordinador(miCoodinador);
		miVentanaConsultarUsuarios.setCoordinador(miCoodinador);	
		miVnetanaConsultarProducto.setCoordinador(miCoodinador);
		miLogicaCompras.setCoordinador(miCoodinador);
		
		//Relacion viseversa 
		miCoodinador.setClienteDAO(misCliente);
		miCoodinador.setComprasDAO(misCompra);
		miCoodinador.setProductoDAO(misProductos);
		miCoodinador.setVentanaPrincipal(miVentaPrincipal);
		miCoodinador.setVentanaCompras(miVentanaCompras);
		miCoodinador.setVentanaProductos(miVentanaProductos);
		miCoodinador.setVentanaRegistrarUsuario(miVentanaRegistroUsuario);
		miCoodinador.setVentanaUsuario(miVentanaUsuarios);
		miCoodinador.setVentanaRegistrarProducto(miRegistroproducto);
		miCoodinador.setVentanaConsultarUsuario(miVentanaConsultarUsuarios);
		miCoodinador.setVentanaConsultarProducto(miVnetanaConsultarProducto);
		miCoodinador.setLogicaCompras(miLogicaCompras);
		
		// metodo para la ventana principal 
		miCoodinador.verVentanaPrincipal();
		
		
		
	}
}
