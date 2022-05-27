package modelo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Miembro;
import modelo.Proyecto;
import procesamiento.CargaDatos;
import procesamiento.EscrituraDatos;

public class Mundo {
    private Map<String, Miembro> mapaMiembros;
	private Map<String, Proyecto> mapaProyectos;
	
	public Mundo() {
        // Cuando se genera el mundo primero tenemos que sacar los miembros
		mapaMiembros = CargaDatos.cargarMiembros();
        // Despues con los miembros hacemos el mapa de proyectos utilizando el mapa de los miembros
        try {
            mapaProyectos  = CargaDatos.cargarProyectos(mapaMiembros);
        } catch (ParseException e) {
            // Si algo sale mal en la carga de datos sale esto
            e.printStackTrace();
        }
    
    }
	public void guardarDatos(){
		EscrituraDatos.GuardarDatos(this);
	}

	public Map<String, modelo.Miembro> darMapaMiembros() {
		return mapaMiembros;
	} 
	
	public Map<String, Proyecto> darMapaProyectos() {
		return mapaProyectos;
	}
	
	public List<Miembro> darListaMiembros() {
		List<Miembro> listaMiembros = new ArrayList<Miembro>();
		
		for (String nombreMiembro: mapaMiembros.keySet()) {
			Miembro miembro = mapaMiembros.get(nombreMiembro);
			listaMiembros.add(miembro);
		}
		return listaMiembros;
	}
	
	public List<Proyecto> darListaProyectos() {
		List<Proyecto> listaProyectos = new ArrayList<Proyecto>();
		
		for (String nombreProyecto: mapaProyectos.keySet()) {
			Proyecto proyecto = mapaProyectos.get(nombreProyecto);
			listaProyectos.add(proyecto);
		}
		return listaProyectos;
	}
	
	public void agregarProyecto(Proyecto proyecto) {
		String nombreProyecto = proyecto.darNombre();
		mapaProyectos.put(nombreProyecto, proyecto);
	}
	
	public void agregarMiembro(Miembro miembro) {
		String nombreMiembro = miembro.darNombre();
		mapaMiembros.put(nombreMiembro, miembro);
	}
	public Proyecto getProyecto(String nombredelProyecto) {
		Proyecto solucion = mapaProyectos.get(nombredelProyecto);
		return solucion;
	}
	public void agregarActividad(String elNombreProyecto,Actividad laActividad){
		Proyecto elProyecto = mapaProyectos.get(elNombreProyecto);
		elProyecto.agregarActividad(laActividad);
	}

	public Actividad getActividad(Proyecto elProyecto,String nombreDeActividad){
		Actividad solucion = null;
		List<Actividad> miLista = elProyecto.darListaActividades();

		for(Actividad actividad: miLista){
			if(actividad.darTitulo().equals(nombreDeActividad)){
				solucion = actividad;
			}
		}

		return solucion;
	}
    public HashMap<String, ArrayList<Actividad>> darReporteActividades(String nombreMiembro) {
		HashMap<String, ArrayList<Actividad>> solucion = null;
		ArrayList<Actividad> miArray = null;
		for(String nombreProyecto :mapaProyectos.keySet()){
			System.out.println("pasamos por el 1er for");
			for(Actividad actividad: mapaProyectos.get(nombreProyecto).darListaActividades()){
				System.out.println("pasamos por el 2do for");
				System.out.println( actividad.darParticipante().darNombre());
				if(actividad.darParticipante().darNombre().equals(nombreMiembro)){
					System.out.println("Encontramos una Coincidencia");
					if(solucion != null ){
						if(solucion.containsKey(nombreProyecto)){
							// Caso en el que ya existe una actividad bajo ese nombre de la key en el mapa
							miArray = solucion.get(nombreProyecto);
							miArray.add(actividad);
							solucion.put(nombreProyecto,miArray);
						}
						else{
							// Caso en el que no existe una actividad bajo ese nombreproyecto
							miArray = new ArrayList<Actividad>();
							miArray.add(actividad);
							solucion.put(nombreProyecto, miArray);
						}
						
					}
					else{
						// Caso inicial donde mi mapa es null
						solucion = new HashMap<String, ArrayList<Actividad>>();
						miArray = new ArrayList<Actividad>();
						miArray.add(actividad);
						solucion.put(nombreProyecto, miArray);
					}
				}
			}
		}
        return solucion;
    }
}
