package clases;
import java.util.HashMap;

import entidades.Operario;

public class ModeloDatos {
	
	HashMap<Integer, Operario> operarioMap;
	
	public ModeloDatos() {
	operarioMap=new HashMap<Integer, Operario>();
	}
	public String registrarOperario(Operario emple) {
	if (!operarioMap.containsKey(emple.getId())) {
		operarioMap.put(emple.getId(), emple);
	return "ok";
	}else {
	return "Operario existente";
	}
	}
	// consultar
	public Operario consultarOperario(int id) {
		Operario estTemporal=null;
		if (operarioMap.containsKey(id)) {
		estTemporal=operarioMap.get(id);
		}
		return estTemporal;
		}
	// eliminar
	public String eliminarOperario(int id) {
		String resultado = "";
		if (operarioMap.containsKey(id)){
			operarioMap.remove(id);
			resultado = " se elimino con exito";
		}else {
			resultado = " no esta el operario";
		}
		return resultado;
	}
	
	// actualizar
	
	public String actualizarOperario(Operario empl) {
		if (operarioMap.containsKey(empl.getId())) {
			operarioMap.put(empl.getId(), empl);
			return "Se registro";
			}else {
			return "No existe el operario";
			}
	}
	
	//// impimir en pantalla los empleados
	public String imprimirOperario() {
		String msj="DATOS ESTUDIANTES\n";
		for (Operario empleOpera : operarioMap.values()) {
		msj+="\n"+"Nombre: "+empleOpera.getNombre()+", Salario: "+empleOpera.getSalario()

		+"\n";

		msj+="Años de antiguadad "+empleOpera.getAñosAntiguedad();
		
		}
		System.out.println(msj);
		return msj;
		}

}
