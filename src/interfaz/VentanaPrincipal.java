package interfaz;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Actividad;
import modelo.Miembro;
import modelo.Mundo;
import modelo.PaqueteDeTrabajo;
import modelo.Proyecto;
import modelo.Tarea;

import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import org.knowm.xchart.*;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.pie.PieChart02;

public class VentanaPrincipal extends JFrame implements ActionListener, ListSelectionListener{
	// Clase encargada de poner la interfaz y manejar los botones de mis paneles

	private PanelProyectos panelProyectos;
	private PanelMiembros panelMiembros;
	private PanelBotones panelBotones;
	private Mundo miMundo; // Este es el link con el mundo
	private JPanel organizacion;
	private PanelPaquetesDeTrabajo panelPaquetes;
	private GraficaPaquetes graficoPaquete;
	private PanelTareas panelTareas;

	// Todas mis Ventanas Auxiliares
	private DialogoNuevoProyecto dialogoCrearNuevoProyecto;
	private DialogoModificarProyecto dialogoModificarProyecto;
	private DialogoModificarActividad dialogomodificarActividad;
	private DialogoNuevaActividad dialogoNuevaActividad;
	private DialogoCrearMiembro dialogoCrearMiembro;
	private DialogoCronometrarActividad dialogoCronometrarActividad;
	private DialogoGenerarReporte dialogoGenerarReporte;
	private DialogoGenerarGraficos dialogoGrafico;
	private DialogoAnadirPaquete dialogoAnadirPaquetes;

	// Constates que se usan como lineas de commandos en los botones de los paneles
	public final static String COMMANDO_GUARDAR = "Porfa Guarda";
	public final static String COMMANDO_GUARDAR_CERRAR = "Porfa Guarda y cierra: plot twist xd";
	public final static String COMMANDO_CREAR_PROYECTO = "CREAME EL PROYECTO PLOX";
    public final static String COMMANDO_MODIFICAR = "MODIFICA PLOX";
    public final static String COMMANDO_CREAR_ACTIVIDAD = "CREAME LA ACTIVIDAD PLOX";
	public final static String COMMANDO_CREAR_Miembro = "CREA UN MIEMBRO";
	public final static String COMMANDO_CRONOMETRAR = ("CRONOMETREA");
	public final static String COMMANDO_REPORTE = ("INICIAR REPORTE");

	public final static String COMMANDO_VENTANA_ATRAS_PROYECTO = "CERRAR ESA MONDA";
    public final static String COMMANDO_VENTANA_CREAR_PROYECTO = "CREA ESO proyecto YA";

	public final static String COMMANDO_DIALOGO_MODIFICAR_ACTIVIDAD_SELECT = "MODIFICA LA ACTIVIDAD EN DIALOGO MODIFICARPROYECTO";
	public final static String COMMANDO_DIALOGO_MODIFICAR_FINALIZACION= "MODIFICA EL PROYECTO SELECT EN DIALOGOPROYECT";
	public final static String COMMANDO_DIALOGO_AGREGAR_PARTICIPANTE= "AGREGA PARTICIPANTE XD UWU";

	public final static String COMMANDO_DIALOGO_ACTIVIDAD_FECHA= "MODIFCA LA FECHADJBAKSDA";
	public final static String COMMANDO_DIALOGO_ACTIVIDAD_HORA_INICIO= "MODIFCA LA HORA DE INICIOASIDOASDSA";
	public final static String COMMANDO_DIALOGO_ACTIVIDAD_HORA_FINAL= "MODIFCA LA HORA DE FINALIZACIONONONO";

	public final static String COMMMANDO_DIALOGO_CREAR_ACTIVIDAD = "Crea una nueva actividad desde el dialogo";

	public static final String COMMMANDO_DIALOGO_CREAR_MIEMBRO = "cREAR UN MIEMBRO DESDE EL DIALOGO";

	public static final String COMMANDO_DIALOGO_PAUSAR_CRONOMETRO = "pAUSA EL CRONOMETRO EN EL DIALOGO";
	public static final String COMMANDO_DIALOGO_INICIAR_CRONOMETRO = "INICIA EL CRONOMETRO DEL DIALOGO";

	public static final String COMMANDO_GRAFICOS = "CREA EL GRAFICO";
	public static final String COMMANDO_ANADIR_PAQUETES = "ANADE UN PAQUETE";
	public static final String COMMANDO_CREAR_PAQUETE ="CREA PAQUETE";
    
	public VentanaPrincipal(){
		// Genera el mundo
		miMundo = new Mundo();
		// Caracteristicas de la ventana principal
		setTitle("Proyecto2");
		setResizable(false);
		setSize(875,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Generamos los 3 paneles que vamos a usar
		panelProyectos = new PanelProyectos(this,miMundo.darMapaProyectos());
		panelMiembros = new PanelMiembros(this,miMundo.darMapaMiembros());
		panelBotones = new PanelBotones(this);
		
		
		// Organizar mis paneles con los layouts y mi jpanel auxiliar organizacion
		organizacion = new JPanel();
		organizacion.setLayout(new GridLayout(2,1));
		add(organizacion, BorderLayout.CENTER);
		organizacion.add(panelProyectos);
		organizacion.add(panelMiembros);
		add(panelBotones, BorderLayout.SOUTH);
		
		// Hace que la ventana principal sea visible
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// Funcion encargada de hacer toda la logica con el mundo
		if (e.getActionCommand().equals( VentanaPrincipal.COMMANDO_GUARDAR)){
			miMundo.guardarDatos();
			System.out.print("COMANDO GUARDAR");
		}
		else if (e.getActionCommand().equals( VentanaPrincipal.COMMANDO_GUARDAR_CERRAR)){
			miMundo.guardarDatos();
			setVisible(false);
			dispose();
			System.out.print("COMANDO GUARDAR Y CERRAR");
		}
		else if(e.getActionCommand().equals(COMMANDO_CREAR_PROYECTO)){
			System.out.print("COMANDO CREAR PROYECTO");
			dialogoCrearNuevoProyecto = new DialogoNuevoProyecto(this);
        }
        else if(e.getActionCommand().equals(COMMANDO_MODIFICAR)){
			System.out.print("COMANDO MODIFICAR");
			String nombredelProyecto = panelProyectos.getSelection();
			Proyecto elProyecto = miMundo.getProyecto(nombredelProyecto);
			
			dialogoModificarProyecto  =new DialogoModificarProyecto(this, elProyecto);
			
            
        }
        else if(e.getActionCommand().equals(COMMANDO_CREAR_ACTIVIDAD)){
			System.out.print("COMANDO CREAR ACTIVIDAD");

			// Necesito encontrar el proyecto
			String nombredelProyecto = panelProyectos.getSelection();
			Proyecto elProyecto = miMundo.getProyecto(nombredelProyecto);

			List<Miembro> listaParticipantes = elProyecto.darListaParticipantes();
			List<String> listaTipos = elProyecto.darListaTiposActividades();

			dialogoNuevaActividad = new DialogoNuevaActividad(this, listaParticipantes , listaTipos);
            
        }
		else if(e.getActionCommand().equals(COMMANDO_GRAFICOS)){

			String nombreProyecto= panelProyectos.getSelection();
			Proyecto elProyecto = miMundo.getProyecto(nombreProyecto);

			if(elProyecto.getListaPaquetesDeTrabajo().isEmpty()){
				PaqueteDeTrabajo paquetePrueba = new PaqueteDeTrabajo("Prueba");
				elProyecto.setListaPaquetesDeTrabajo(paquetePrueba);
			}
			panelPaquetes = new PanelPaquetesDeTrabajo(this, miMundo.darListaPaqueteTrabajo(elProyecto));
			String nombrePaquete = panelPaquetes.getSelection();
			PaqueteDeTrabajo elPaquete = miMundo.getPaqueteDeTrabajo(elProyecto, nombrePaquete);			
			
			List<PaqueteDeTrabajo> lista_paquetes = miMundo.darListaPaqueteTrabajo(elProyecto);
			List<Tarea> lista_tareas = miMundo.darListaTareas(elPaquete);

			if(lista_tareas.isEmpty()){
				Tarea laTarea2 = new Tarea("Prueba", "");
				miMundo.agregarTarea(elPaquete, laTarea2);
			}

			panelTareas = new PanelTareas(this, lista_tareas);
			String nombre_tarea = panelTareas.getSelection();
			Tarea laTarea = miMundo.getTarea(elPaquete, nombre_tarea);
			List<Actividad> lista_actividades = laTarea.getActividades();
			if(lista_actividades.isEmpty())
			{	
				Actividad laActividad = new Actividad("Prueba", "", "", null, null, null, null);
				miMundo.agregarActividad(laTarea, laActividad);
			}
			dialogoGrafico = new DialogoGenerarGraficos(this, lista_paquetes, lista_tareas, lista_actividades);
		}
		else if(e.getActionCommand().equals(COMMANDO_ANADIR_PAQUETES)){

			new DialogoAnadirPaquete(this);
		}
		else if(e.getActionCommand().equals(COMMANDO_CREAR_PAQUETE)){
			String nombreProyecto= panelProyectos.getSelection();
			Proyecto elProyecto = miMundo.getProyecto(nombreProyecto);
			String nombre = dialogoAnadirPaquetes.darBoxNombre();
			PaqueteDeTrabajo elPaquete = new PaqueteDeTrabajo(nombre);
			elProyecto.setListaPaquetesDeTrabajo(elPaquete);

		}
		
		else if(e.getActionCommand().equals(COMMANDO_CREAR_Miembro)){
			System.out.print("COMANDO CREAR MIEMBRO");
			dialogoCrearMiembro = new DialogoCrearMiembro(this);


		}

		else if(e.getActionCommand().equals(COMMANDO_CRONOMETRAR)){
			System.out.print("COMANDO CRONOMETRAR");
			dialogoCronometrarActividad = new DialogoCronometrarActividad(this);
			

		}

		else if(e.getActionCommand().equals(COMMANDO_REPORTE)){
			System.out.print("COMANDO REPORTE");
			String nombreMiembro = panelMiembros.getMiembroSeleccionado();
			HashMap<String,ArrayList<Actividad>> mapaProyectoActividades =  miMundo.darReporteActividades(nombreMiembro);
			dialogoGenerarReporte = new DialogoGenerarReporte(mapaProyectoActividades, nombreMiembro);
		}

		else if(e.getActionCommand().equals(COMMANDO_VENTANA_ATRAS_PROYECTO)){
			dialogoCrearNuevoProyecto.CerrarDialogo();
		}
		else if (e.getActionCommand().equals(COMMANDO_VENTANA_CREAR_PROYECTO)){
			String stringPartes = dialogoCrearNuevoProyecto.ObtenerInformacionCampos();
			String[] partes = stringPartes.split(">");

				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date fechaInicio = null;
				java.util.Date fechaFin= null;
				try {
					fechaInicio = df.parse(partes[3]);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					fechaFin = df.parse(partes[4]);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			Proyecto proyecto = new Proyecto(partes[0], partes[1], fechaInicio);
			proyecto.agregarFechaFin(fechaFin);
			proyecto.agregarTipoActividad(partes[2]);
			Map<String, modelo.Miembro> misMiembros = miMundo.darMapaMiembros();
			Miembro miMiembro = null;
			for(String nameMiembro: misMiembros.keySet()){
				if(nameMiembro.equals(partes[5])){
					miMiembro = misMiembros.get(nameMiembro);
				}
			}

			if(miMiembro != null){
				proyecto.agregarParticipante(miMiembro);}
			else{
				System.out.println("ERROR: ESE MIEMBRO NO ESTA EN LA LISTA DE MIEMBROS, NO FUE AGREGADO");
			}
			miMundo.agregarProyecto(proyecto);

			dialogoCrearNuevoProyecto.CerrarDialogo();
			organizacion.remove(panelProyectos);
			panelProyectos = new PanelProyectos(this,miMundo.darMapaProyectos());
			organizacion.add(panelProyectos,0);
			organizacion.invalidate();
			organizacion.validate();
		}
		// REACCIONES A DIALOGO MODIFICAR PROYECTO
		else if (e.getActionCommand().equals(COMMANDO_DIALOGO_MODIFICAR_ACTIVIDAD_SELECT)){
			System.out.println("Comando Modificar Actividad");

			String nombreActividad = dialogoModificarProyecto.darNombreActividadActual();
			String nombredelProyecto = panelProyectos.getSelection();
			Proyecto elProyecto = miMundo.getProyecto(nombredelProyecto);

			Actividad laActividad = miMundo.getActividad(elProyecto, nombreActividad);

			dialogomodificarActividad = new  DialogoModificarActividad(this, laActividad);

		}
		else if (e.getActionCommand().equals(COMMANDO_DIALOGO_MODIFICAR_FINALIZACION)){
			System.out.println("Comando Modificar Finalizacion");

		}
		else if (e.getActionCommand().equals(COMMANDO_DIALOGO_AGREGAR_PARTICIPANTE)){
			System.out.println("Comando agregar Participante");


		}
		// REACCIONES A DIALOGO MODIFICAR ACTIVIDAD
		else if (e.getActionCommand().equals(COMMANDO_DIALOGO_ACTIVIDAD_FECHA)){
			System.out.println("Comando editar Actividad fecha");

		}
		else if (e.getActionCommand().equals(COMMANDO_DIALOGO_ACTIVIDAD_HORA_INICIO)){
			System.out.println("Comando editar hora inicio actividad");

		}
		else if (e.getActionCommand().equals(COMMANDO_DIALOGO_ACTIVIDAD_HORA_FINAL)){
			System.out.println("Comando editar hora final actividad");

		}
		else if (e.getActionCommand().equals(COMMMANDO_DIALOGO_CREAR_ACTIVIDAD)){
			System.out.println("Comando Crear Actividad Dialogo");
			// añadirle la actividad al proyecto seleccionado
			String nombreProyecto = panelProyectos.getSelection();
			String elTitulo = dialogoNuevaActividad.getBoxNombre();
			String laDescripcion = dialogoNuevaActividad.getBoxDescripcion();
			String elTipo = dialogoNuevaActividad.getBoxTipo();
			String nombreParticipante = dialogoNuevaActividad.getBoxNombreMiembro();
			Miembro elParticipante = miMundo.darMapaMiembros().get(nombreParticipante);

			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String fechaInicioString = dialogoNuevaActividad.getBoxFecha();
			java.util.Date laFecha = null;
			try {
				laFecha = df.parse(fechaInicioString);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			DateFormat dft = new SimpleDateFormat("hh:mm:ss");
			java.util.Date laHoraInicio = null;
			try {
				laHoraInicio = dft.parse(dialogoNuevaActividad.getBoxInicio());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			java.util.Date laHoraFin = null;
			try {
				laHoraFin = dft.parse(dialogoNuevaActividad.getBoxFin());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Actividad miActividad = new Actividad(elTitulo, laDescripcion, elTipo, elParticipante, laFecha, laHoraInicio, laHoraFin);
			miMundo.agregarActividad(nombreProyecto, miActividad);

			dialogoNuevaActividad.CerrarDialogo();
			organizacion.remove(panelProyectos);
			panelProyectos = new PanelProyectos(this,miMundo.darMapaProyectos());
			organizacion.add(panelProyectos,0);
			organizacion.invalidate();
			organizacion.validate();
			
		}
		else if (e.getActionCommand().equals(COMMMANDO_DIALOGO_CREAR_MIEMBRO)){
			System.out.println("Comando Crear MIEMBRO EN DIALOGO");
			Miembro miMiembro = new Miembro(dialogoCrearMiembro.darBoxNombre(), dialogoCrearMiembro.darBoxCorreo());
			miMundo.agregarMiembro(miMiembro);

			organizacion.remove(panelMiembros);
			panelMiembros = new PanelMiembros(this,miMundo.darMapaMiembros());
			organizacion.add(panelMiembros,1);
			organizacion.invalidate();
			organizacion.validate();

		}

		// Reacciones a cronometro Dialogo
		else if (e.getActionCommand().equals(COMMANDO_DIALOGO_PAUSAR_CRONOMETRO)){
			System.out.println("Comando PAUSAR CRONOMETRO");
			dialogoCronometrarActividad.PausarCronometroSegundos();
			

		}
		else if (e.getActionCommand().equals(COMMANDO_DIALOGO_INICIAR_CRONOMETRO)){
			System.out.println("Comando INICIAR CRONOMETRO");
			dialogoCronometrarActividad.iniciarCronometro();

		}

		


		

	}

	public void actualizarProyectos(){
		panelProyectos.actualizarProyectos(this, miMundo.darMapaProyectos());
	}

	public void actualizarMiembros(){
		panelMiembros.actualizarMiembros(this,miMundo.darMapaMiembros());
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// evento que acontese cuando cambias de posicion, solo necesito que me diga de donde viene

		if (e.getSource().equals(panelMiembros.getpanelScrollList())){
			// Significa que viene desde miembros y sucedio algo
			System.out.println("Cambio algo en miembros");
		}
		else{
			// Significa que viene de proyectos y sucedio algo
			System.out.println("Cambio algo en Proyectos");
		}
	}

    public static void main(String[] args) throws ParseException {
		VentanaPrincipal miVentana = new VentanaPrincipal();
		
		
	}


}

