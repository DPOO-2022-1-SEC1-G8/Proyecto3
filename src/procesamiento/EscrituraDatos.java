package procesamiento;

import modelo.Actividad;
import modelo.Proyecto;
import modelo.Miembro;
import modelo.Mundo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class EscrituraDatos {

	private static void GuardarMiembros(Mundo mundo) {
		String rutaGeneral = System.getProperty("user.dir");
		String rutaArchivoMiembros = rutaGeneral + "\\Proyecto_2\\data\\Miembros.txt";
		File archivoMiembros = new File(rutaArchivoMiembros);
		
		List<Miembro> listaMiembros = mundo.darListaMiembros();
			
		try {
			FileWriter writer = new FileWriter(archivoMiembros);
			for (Miembro miembro : listaMiembros) {

				String lineaMiembro = EscribirMiembro(miembro);
				lineaMiembro += "\n";
				writer.append(lineaMiembro);
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo 'Miembros.txt'");
			e.printStackTrace();
		}
	}
	
	private static void GuardarProyectos(Mundo mundo) {
		String rutaGeneral = System.getProperty("user.dir");
		String rutaArchivoProyectos = rutaGeneral + "\\Proyecto_2\\data\\Proyectos.txt";
		File archivoProyectos = new File(rutaArchivoProyectos);
		
		List<Proyecto> listaProyectos = mundo.darListaProyectos();
			
		try {
			FileWriter writer = new FileWriter(archivoProyectos);
			for (Proyecto proyecto : listaProyectos) {
				String nombreProyecto = proyecto.darNombre();
				String descripcionProyecto = proyecto.darDescripcion();
				List<String> tiposActividades = proyecto.darListaTiposActividades();
				java.util.Date fechaInicio = proyecto.darFechaInicio();
				java.util.Date fechaFin = proyecto.darFechaFin();
				List<Miembro> listaParticipantes = proyecto.darListaParticipantes();
				List<Actividad> listaActividades = proyecto.darListaActividades();
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
				String fechaInicioString = df.format(fechaInicio);
				String fechaFinString = df.format(fechaFin); 
				
				String lineaProyecto = "";
				lineaProyecto += nombreProyecto + "<" + descripcionProyecto + "<";
				
				for (String tipoActividad: tiposActividades) {
					lineaProyecto += tipoActividad + ">";
				}
				
				lineaProyecto += "<" + fechaInicioString + "<" + fechaFinString + "<";
				
				for (Miembro participante : listaParticipantes) {
					String nombreParticipante = participante.darNombre();
					lineaProyecto += nombreParticipante + ">";
				}
				
				lineaProyecto += "<";
				
				for (Actividad actividad: listaActividades) {
					String lineaActividad = EscribirActividad(actividad);
					lineaProyecto += lineaActividad + ">";
				}
				
				lineaProyecto += "\n";
				writer.append(lineaProyecto);
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo 'Miembros.txt'");
			e.printStackTrace();
		}
	}
	
	private static String EscribirMiembro(Miembro miembro) {
		String linea = "";
		String nombreMiembro = miembro.darNombre();
		String correoMiembro = miembro.darCorreo();
		
		linea += nombreMiembro + "<" + correoMiembro;
		
		return linea;
	}
	
	private static String EscribirActividad(Actividad actividad) {
		String linea = "";
		String tituloActividad = actividad.darTitulo();
		String descripcionActividad = actividad.darDescripcion();
		String tipoActividad = actividad.darTipo();
		Miembro participanteActividad = actividad.darParticipante();
		String nombreParticipante = participanteActividad.darNombre();
		java.util.Date fechaActividad = actividad.darFecha();
		java.util.Date horaInicioActividad = actividad.darHoraInicio();
		java.util.Date horaFinActividad = actividad.darHoraFin();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
		String fechaActividadString = df.format(fechaActividad);
		
		DateFormat dft = new SimpleDateFormat("HH:mm:ss");
		String horaInicioActividadString = dft.format(horaInicioActividad);
		String horaFinActividadString = dft.format(horaFinActividad);
		
		linea += tituloActividad + "¿";
		linea += descripcionActividad + "¿";
		linea += tipoActividad + "¿";
		linea += nombreParticipante + "¿";
		linea += fechaActividadString + "¿";
		linea += horaInicioActividadString + "¿";
		linea += horaFinActividadString + "¿";
		
		return linea;
	}
	
	public static void GuardarDatos(Mundo mundo) {
		GuardarMiembros(mundo);
		GuardarProyectos(mundo);
	}

}