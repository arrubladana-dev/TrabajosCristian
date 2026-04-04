package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import controlador.Coordinador;
import modelo.dto.ComprasDTO;
import modelo.dto.ProductosDTO;

public class ComprasDAO {
	private Coordinador miCoodinador;
	
	//Aqui empieza 
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
//		private String conectar() {
//			Conexion conexion = new Conexion();
//			String resu
//		}
		
		
//		------------------------------------------Registrar-------------------------------------------------------------------------------
		public String registrarCompra(ComprasDTO compra) {

		    String resultado = "";
		    connection = conexion.getConnection();

		    String consulta = "INSERT INTO FacturaCompra (descuento, compraRealizada, total, documento, codigoProducto) VALUES (?,?,?,?,?)";

		    try {
		        preStatement = connection.prepareStatement(consulta);

		        preStatement.setDouble(1, compra.getDescuento());
		        preStatement.setDouble(2, compra.getCompraRealizada()); 
		        preStatement.setDouble(3, compra.getTotal()); 
		        preStatement.setString(4, compra.getDocumento());
		        preStatement.setString(5, compra.getCodigoProducto());

		        preStatement.execute();

		        resultado = "ok";

		    } catch (SQLException e) {
		        e.printStackTrace();
		        resultado = "error";
		    } finally {
		        conexion.desconectar();
		    }

		    return resultado;
		}
		//-------------------------------------consultar-------------------------------------wi
		public ProductosDTO consultarProducto(String codigo) {
			Connection connection=null;
			Conexion miConexion=new Conexion();
			PreparedStatement statement=null;
			ResultSet result=null;
			
			ProductosDTO miProducto = new ProductosDTO();
			
			
			connection=miConexion.getConnection();
			
			String consulta="SELECT * FROM Producto where idCodigoProducto= ? ";
			
			try {
				if (connection!=null) {
					statement=connection.prepareStatement(consulta);
					statement.setString(1, codigo);
					
					result=statement.executeQuery();
					
					while(result.next()==true){
						//miProducto=new ProductosDTO();
						miProducto.setCodigo(result.getString("idCodigoProducto"));
						miProducto.setNombreProducto(result.getString("nombreProducto"));
						miProducto.setPrecio(Double.parseDouble(result.getString("precio")));
						miProducto.setCantidad(Integer.parseInt(result.getString("cantidad")));
						//miEmpleado.setSalario(Double.parseDouble(result.getString("salario")));
					}		
					   miConexion.desconectar();
				}else{
					miProducto=null;
				}
				
				   
			} catch (SQLException e) {
				System.out.println("Error en la consulta del usuario: "+e.getMessage());
				e.printStackTrace();
			}
			
			return miProducto;
		}
		// -----------------------------------------lista----------------------------------------------------------
		
		public ArrayList<ProductosDTO> consultarListaProductos() throws SQLException {
			ArrayList<ProductosDTO> listaProductos=new ArrayList<ProductosDTO>();
			
			connection = conexion.getConnection();
			
			if (connection==null) {
				return listaProductos;
			}
			
			ResultSet result=null;
			ProductosDTO miProducto=null;
			
			
			//String consulta = "INSERT INTO Producto (idCodigoProducto,nombreProducto,precio,cantidad)"
			String consulta="SELECT idCodigoProducto,nombreProducto,precio,cantidad"
					+ " FROM Producto ";
			
			try {
				preStatement=connection.prepareStatement(consulta);
					
				result=preStatement.executeQuery();
					
				while(result.next()==true){
					miProducto=new ProductosDTO();
					miProducto.setCodigo(result.getString("idCodigoProducto"));
					miProducto.setNombreProducto(result.getString("nombreProducto"));
					miProducto.setPrecio(Double.parseDouble(result.getString("precio")));
					miProducto.setCantidad(Integer.parseInt(result.getString("cantidad")));
					//miEmpleado.setSalario(Double.parseDouble(result.getString("salario")));
					//miEstudiante.setPromedio(result.getDouble("promedio"));
					listaProductos.add(miProducto);
				}		
				   
			} catch (SQLException e) {
				System.out.println("Error en la consulta de personas: "+e.getMessage());
			}finally {
				result.close();
				preStatement.close();
				connection.close();
				conexion.desconectar();
			}
				return listaProductos;
		}
		//--------------------------------------Actualizar-------------------------------------------------
		public String actualizarProducto (ProductosDTO producto) throws SQLException {
			
			
			String resultado="";
			connection = conexion.getConnection();

			if (connection==null) {
				return "Error";
			}

			try{
				
				
				String consulta="UPDATE Producto "
						+ "SET nombreProducto = ? , "
						+ "precio= ? , "
						+ "cantidad= ? "
						+ "WHERE idCodigoProducto= ?;";
				preStatement = connection.prepareStatement(consulta);

				preStatement.setString(1,producto.getNombreProducto());
				preStatement.setDouble(2, producto.getPrecio());
				preStatement.setInt(3, producto.getCantidad());
				preStatement.setString(4, producto.getCodigo());
				preStatement.executeUpdate();
				
	          resultado="ok";
	          
	        }catch(SQLException	 e){
	            System.out.println("Ocurrió una excepcion de SQL "
	            		+ "al momento de actualizar: "+e);
	            resultado="error";
	        }finally {
				preStatement.close();
				connection.close();
				conexion.desconectar();
			}
			return resultado;
		}
		
		// -------------------------------------eliminar --------------------------------------------------
		public String eliminarProducto(String codigo) throws SQLException {
//			DELETE FROM empleados
//			WHERE id_empleado = 10;
			String respuesta = "";
			connection = conexion.getConnection();
			//ResultSet result=null;
			
			if (connection==null) {
				return "error";
			}
			
			
			try {	
				//String consulta = "INSERT INTO Producto (idCodigoProducto,nombreProducto,precio,cantidad)"
				String consulta = "DELETE FROM Producto WHERE idCodigoProducto = ? ";

		        preStatement = connection.prepareStatement(consulta);
		        preStatement.setString(1, codigo);

		        preStatement.executeUpdate();

		        respuesta = "ok";
				
				
				
				   
			} catch (SQLException e) {
				System.out.println("Error en la consulta del usuario: "+e.getMessage());
				e.printStackTrace();
				respuesta = "error";
				System.out.println("wiqq");	
			}finally {
//				preStatement.close();
//				connection.close();
				conexion.desconectar();
			}
			
			
			return respuesta;
			
		}
		
		

	
//// cordinador--------------------------------------------------------	

	public void setCoordinador(Coordinador miCoodinador) {
		this.miCoodinador = miCoodinador;
	}

}
