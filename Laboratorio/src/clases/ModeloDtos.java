package clases;

import java.util.HashMap;

import entidades.Estudiante;

public class ModeloDtos {
	
	HashMap<Integer, Estudiante> estudiantesMap;
	public ModeloDtos() {
	estudiantesMap=new HashMap<Integer, Estudiante>();
	}
	public String registrarEstudiante(Estudiante est) {
	if (!estudiantesMap.containsKey(est.getDocumento())) {
	estudiantesMap.put(est.getDocumento(), est);
	return "ok";
	}else {
	return "Estudiante existente";
	}
	}
	
	public Estudiante consultaEstudiante(int documento) {
	Estudiante estTemporal=null;
	if (estudiantesMap.containsKey(documento)) {
	estTemporal=estudiantesMap.get(documento);
	}
	return estTemporal;
	}
	
	public String imprimirListaEstudiantes() {
	String msj="DATOS ESTUDIANTES\n";
	for (Estudiante estudiante : estudiantesMap.values()) {
	msj+="Nombre: "+estudiante.getNombre()+", Materia: "+estudiante.getMateria()

	+"\n";

	msj+="Nota1: "+estudiante.getNota1()+", Nota2: "+estudiante.getNota2()+", ";
	msj+="Nota3: "+estudiante.getNota3()+", Promedio:"+estudiante.getPromedio()+ "\n\n";
	}
	System.out.println(msj);
	return msj;
	}
	
	public String eliminarEstudiante(int documento) {
		String resultado = "";
		if (estudiantesMap.containsKey(documento)){
			estudiantesMap.remove(documento);
			resultado = " se elimino con exito";
		}else {
			resultado = " no esta el estudiante";
		}
		return resultado;
	}
	
	public String actualizarEstudiante(Estudiante est) {
		if (estudiantesMap.containsKey(est.getDocumento())) {
			estudiantesMap.put(est.getDocumento(), est);
			return "Se registro";
			}else {
			return "No existe el estudiante que te fumaste";
			}
	}

}
