package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Proyecto {
	private String nombre;
	private String descripcion;
	private List<String> listaTiposActividades;
	private java.util.Date fechaInicio;
	private java.util.Date fechaFin;
	private Map<String, Miembro> mapaParticipantes;
	private List<Actividad> listaActividades;
	
	public Proyecto(String elNombre, String laDescripcion, Date laFechaInicio) {
		this.nombre = elNombre;
		this.descripcion = laDescripcion;
		this.listaTiposActividades = new ArrayList<String>();
		this.fechaInicio = laFechaInicio;
		this.mapaParticipantes = new HashMap<String, Miembro>();
		this.listaActividades = new ArrayList<Actividad>();
	}

	public String darNombre() {
		return nombre;
	}
	
	public String darDescripcion() {
		return descripcion;
	}
	
	public List<String> darListaTiposActividades() {
		return listaTiposActividades;
	}
	
	public java.util.Date darFechaInicio() {
		return fechaInicio;
	}
	
	public java.util.Date darFechaFin() {
		return fechaFin;
	}
	
	public Map<String, Miembro> darMapaParticipantes() {
		return mapaParticipantes;
	}
	
	public List<Actividad> darListaActividades() {
		return listaActividades;
	}
	
	public List<Miembro> darListaParticipantes() {
		List<Miembro> listaParticipantes = new ArrayList<Miembro>();
		
		for (String nombreParticipante: mapaParticipantes.keySet()) {
			Miembro participante = mapaParticipantes.get(nombreParticipante);
			listaParticipantes.add(participante);
		}
		return listaParticipantes;
	}
	
	public void agregarFechaFin(java.util.Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public void agregarTipoActividad(String tipoActividad) {
		listaTiposActividades.add(tipoActividad);
	}
	
	public void agregarParticipante(Miembro participante) {
		String nombreParticipante = participante.darNombre();
		mapaParticipantes.put(nombreParticipante, participante);
	}
	
	public void agregarActividad(Actividad actividad) {
		listaActividades.add(actividad);
	}
	
	
}