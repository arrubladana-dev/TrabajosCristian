package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import controlador.Coordinador;
import modelo.dto.ClienteDTO;

public class ClienteDAO {
	private Coordinador miCoodinador;
	
	//Aqui empieza 
	Connection connection = null;
	Conexion conexion = new Conexion();
	PreparedStatement preStatement = null;
//	private String conectar() {
//		Conexion conexion = new Conexion();
//		String resu
//	}
//	
	public String registrarUsuario(ClienteDTO miCliente) {
		String resultado = "";

		connection = conexion.getConnection();
		String consulta = "INSERT INTO Usuario (idDocumento,nombreUsuario,ApellidoUsuario,edad,telefono,tipo)"
				+ "  VALUES (?,?,?,?,?,?)";

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miCliente.getDocumento());
			preStatement.setString(2, miCliente.getNombreUsuario());
			preStatement.setString(3, miCliente.getApellidoUsuario());
			preStatement.setInt(4, miCliente.getEdad());
			preStatement.setString(5, miCliente.getTelefono());
			preStatement.setString(6, miCliente.getTipo());
			preStatement.execute();

			resultado = "ok";

		} catch (SQLException e) {
			System.out.println("No se pudo registrar el Usuario: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar el Usuario";
		} finally {
			conexion.desconectar();
		}

		return resultado;
	}
	//-------------------------------------consultar-------------------------------------wi
	public ClienteDTO consultarUsuario(String doc) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		ClienteDTO miCliente=new ClienteDTO();
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM Usuario where idDocumento= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setString(1, doc);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miCliente=new ClienteDTO();
					miCliente.setDocumento(result.getString("idDocumento"));
					miCliente.setNombreUsuario(result.getString("nombreUsuario"));
					miCliente.setApellidoUsuario(result.getString("ApellidoUsuario"));
					miCliente.setEdad(Integer.parseInt(result.getString("edad")));
					miCliente.setTelefono(result.getString("telefono"));
					//miEmpleado.setSalario(Double.parseDouble(result.getString("salario")));
					miCliente.setTipo(result.getString("tipo"));
				}		
				   miConexion.desconectar();
			}else{
				miCliente=null;
			}
			
			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: "+e.getMessage());
			e.printStackTrace();
		}
		
		return miCliente;
	}
	// -----------------------------------------lista----------------------------------------------------------
	
	public ArrayList<ClienteDTO> consultarListaUsuarios() throws SQLException {
		ArrayList<ClienteDTO> listaUsuarios=new ArrayList<ClienteDTO>();
		
		connection = conexion.getConnection();
		
		if (connection==null) {
			return listaUsuarios;
		}
		
		ResultSet result=null;
		ClienteDTO miCliente=null;
		
		
		
		String consulta="SELECT idDocumento,nombreUsuario,ApellidoUsuario,edad,telefono,tipo"
				+ " FROM Usuario ";
		
		try {
			preStatement=connection.prepareStatement(consulta);
				
			result=preStatement.executeQuery();
				
			while(result.next()==true){
				miCliente=new ClienteDTO();
				miCliente.setDocumento(result.getString("idDocumento"));
				miCliente.setNombreUsuario(result.getString("nombreUsuario"));
				miCliente.setApellidoUsuario(result.getString("ApellidoUsuario"));
				miCliente.setEdad(Integer.parseInt(result.getString("edad")));
				miCliente.setTelefono(result.getString("telefono"));
				//miEmpleado.setSalario(Double.parseDouble(result.getString("salario")));
				miCliente.setTipo(result.getString("tipo"));
				//miEstudiante.setPromedio(result.getDouble("promedio"));
				listaUsuarios.add(miCliente);
			}		
			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de personas: "+e.getMessage());
		}finally {
			result.close();
			preStatement.close();
			connection.close();
			conexion.desconectar();
		}
			return listaUsuarios;
	}
	//--------------------------------------Actualizar-------------------------------------------------
	public String actualizarUsuarios (ClienteDTO usuario) throws SQLException {
		
		
		String resultado="";
		connection = conexion.getConnection();

		if (connection==null) {
			return "Error";
		}

		try{
			String consulta="UPDATE Usuario "
					+ "SET nombreUsuario = ? , "
					+ "ApellidoUsuario= ? , "
					+ "edad= ? , "
					+ "telefono= ? , "
					+ "tipo= ?  "
					+ "WHERE idDocumento= ?;";
			preStatement = connection.prepareStatement(consulta);

			preStatement.setString(1,usuario.getNombreUsuario());
			preStatement.setString(2, usuario.getApellidoUsuario());
			preStatement.setInt(3, usuario.getEdad());
			preStatement.setString(4, usuario.getTelefono());
			preStatement.setString(5, usuario.getTipo());
			preStatement.setString(6, usuario.getDocumento());
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
	public String eliminarUsuario(String documneto) throws SQLException {
//		DELETE FROM empleados
//		WHERE id_empleado = 10;
		String respuesta = "";
		connection = conexion.getConnection();
		//ResultSet result=null;
		
		if (connection==null) {
			return "error";
		}
		
		
		try {	
				   
			String consulta = "DELETE FROM usuario WHERE idDocumento = ? ";

	        preStatement = connection.prepareStatement(consulta);
	        preStatement.setString(1, documneto);

	        preStatement.executeUpdate();

	        respuesta = "ok";
			
			
			
			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: "+e.getMessage());
			e.printStackTrace();
			respuesta = "error";
			System.out.println("wiqq");	
		}finally {
//			preStatement.close();
//			connection.close();
			conexion.desconectar();
		}
		
		
		return respuesta;
		
	}
	
	
	// cprdinador 
	public void setCoordinador(Coordinador miCoodinador) {
		this.miCoodinador = miCoodinador;
	}


}
