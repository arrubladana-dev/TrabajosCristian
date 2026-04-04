package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class Conexion {
	private String nombreBd="DonAparatoTienda";
	private String usuario="root";
	private String password="";
	private String url="jdbc:mysql://localhost:3306/"+nombreBd+"?useUnicode=true&use"
			+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
			+ "serverTimezone=UTC";

	Connection conn=null;
	//constructor de la clase
	
	public String conectar() {
		String respuesta="";
		try {
			//obtener el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//obtener la conexion
			conn=DriverManager.getConnection(url,usuario,password);
			if (conn!=null) {
				respuesta="conectado";
			}else{
				respuesta="NO SE PUDO CONECTAR "+nombreBd;
			}
		}
		catch (ClassNotFoundException e) {
			respuesta="ocurre una ClassNotFoundException : "+e.getMessage();
		}
		catch (SQLSyntaxErrorException e) {
			respuesta="ocurre una SQLSyntaxErrorException: "+e.getMessage()+"\n";
			respuesta+="Verifique que se esté usando la base de datos y tablas correctas...";
		}
		catch (CommunicationsException e) {
			respuesta="ocurre una CommunicationsException: "+e.getMessage()+"\n";
			respuesta+="Verifique que la base de datos fué iniciada...";
		}
		catch (SQLException e) {
			respuesta="ocurre una SQLException: "+e.getMessage()+"\n";
			respuesta+="Este es un problema general de SQL, verifique con el administrador";
		}
		
		return respuesta;
	}
	
	public Conexion(){
		try {
			//obtener el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//obtener la conexion
			conn=DriverManager.getConnection(url,usuario,password);
			if (conn!=null) {
				System.out.println("Conexion Exitosa  a la BD: "+nombreBd);
			}else{
				System.out.println("******************NO SE PUDO CONECTAR "+nombreBd);
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("ocurre una ClassNotFoundException : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("ocurre una SQLException: "+e.getMessage());
			System.out.println("Verifique que Mysql esté encendido...");
		}
	}
	public Connection getConnection(){
		
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver"); 
			 conn=DriverManager.getConnection(url,usuario,password);
		    } catch (Exception e) {
		        System.out.println("Error al conectar: " + e.getMessage());
		    }
		return conn;
	}
	public void desconectar(){
		conn=null;
	}
}