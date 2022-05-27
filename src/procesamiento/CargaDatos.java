package procesamiento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.Miembro;
import modelo.Actividad;
import modelo.Proyecto;

public final class CargaDatos {

	public static  Map<String, modelo.Miembro> cargarMiembros() {
		String rutaGeneral = System.getProperty("user.dir");
		String rutaArchivoMiembros = rutaGeneral + "\\Proyecto_2\\data\\Miembros.txt"; // Nota: Aqui tuve que editar una cosa pq no estaba funcionando por mis carpetas raras
		File archivoMiembros = new File(rutaArchivoMiembros);
		
		Map<String, Miembro> mapaMiembros = new HashMap<String, Miembro>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoMiembros))){
	        String linea;
	        // Cuando se llegue al final del archivo, linea tendr¿ el valor null.
	        while ((linea = br.readLine()) != null) {
	        	String[] partes = linea.split("<");
	        	String nombre = partes[0];
	        	String correo = partes[1];
	        	Miembro infoMiembro = new Miembro(nombre, correo);
	        	mapaMiembros.put(nombre,infoMiembro); 
	        	}     
	        }
	        catch (FileNotFoundException e) {
	            System.out.println("ERROR: el archivo indicado no se encontr¿.");
	        }
	        catch (IOException e) {
	            System.out.println("ERROR: hubo un problema leyendo el archivo.");
	            System.out.println(e.getMessage());
	        }
		return mapaMiembros;
	}
	
	public static Map<String, modelo.Proyecto> cargarProyectos(Map<String, modelo.Miembro> mapaMiembros) throws ParseException {
		String rutaGeneral = System.getProperty("user.dir");
		String rutaArchivoProyectos = rutaGeneral + "\\Proyecto_2\\data\\Proyectos.txt";
		File archivoProyectos = new File(rutaArchivoProyectos);
		
		Map<String, Proyecto> mapaProyectos = new HashMap<String, Proyecto>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoProyectos))){
	        String linea;
	        // Cuando se llegue al final del archivo, linea tendr¿ el valor null.
	        while ((linea = br.readLine()) != null) {
	        	String[] partes = linea.split("<");
	        	String nombre = partes[0];
	        	String descripcion = partes[1];
	        	String tipos = partes[2];
	        	String fechaInicioString = partes[3];
	        	String fechaFinString = partes[4];
	        	String participantes = partes[5];
	        	String actividades= partes[6];
	        	
	        	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	        	
	        	java.util.Date fechaInicio = df.parse(fechaInicioString);
	        	java.util.Date fechaFin = df.parse(fechaFinString);
	        	
	        	Proyecto proyecto = new Proyecto(nombre, descripcion, fechaInicio);
	        	proyecto.agregarFechaFin(fechaFin);
	        	
	        	List<String> listaTiposAtividades = proyecto.darListaTiposActividades();
	        	String[] listaTipos = tipos.split(">");
	        	for (String tipoActividad: listaTipos) {
	        		listaTiposAtividades.add(tipoActividad);
	        	}
	        	
	        	String[] listaParticipantes = participantes.split(">");
	        	for (String nombreParticipante: listaParticipantes) {
	        		Miembro infoParticipante = mapaMiembros.get(nombreParticipante);
	        		proyecto.agregarParticipante(infoParticipante);
	        	}
	        	
	        	String[] stringListaActividades = actividades.split(">");
	        	for (String stringInfoActividad: stringListaActividades) {
	        		String[] InfoActividad = stringInfoActividad.split("¿");
	        		String tituloA = InfoActividad[0];
	        		String descripcionA = InfoActividad[1];
	        		String tipoA = InfoActividad[2];
	        		String nombreParticipanteA = InfoActividad[3];
	        		String fechaA = InfoActividad[4];
	        		String horaInicioAString = InfoActividad[5];
	        		String horaFinAString = InfoActividad[6];
	        		java.util.Date fecha = df.parse(fechaA);
	        		
	        		DateFormat dft = new SimpleDateFormat("hh:mm:ss");
	        		java.util.Date horaInicioA = dft.parse(horaInicioAString);
	        		java.util.Date horaFinA = dft.parse(horaFinAString);
	        		
	        		Miembro infoParticipanteA = mapaMiembros.get(nombreParticipanteA.substring(0, nombreParticipanteA.length() - 1));
	        		Actividad infoActividad = new Actividad(tituloA, descripcionA, tipoA,
	        											infoParticipanteA, fecha, horaInicioA, horaFinA);
	        		proyecto.agregarActividad(infoActividad);
	        	}
	        	mapaProyectos.put(nombre, proyecto);
	          }     
	        }
	        catch (FileNotFoundException e) {
	            System.out.println("ERROR: el archivo indicado no se encontr¿.");
	        }
	        catch (IOException e) {
	            System.out.println("ERROR: hubo un problema leyendo el archivo.");
	            System.out.println(e.getMessage());
	        }
		return mapaProyectos;
	}
	
}