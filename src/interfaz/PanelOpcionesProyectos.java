package interfaz;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.*;

public class PanelOpcionesProyectos extends JPanel {
    private JButton btonCrearProyecto;
    private JButton btonmodificarProyecto;
    private JButton btonCrearActividad;
    private JButton btonCrearGraficos;

    public PanelOpcionesProyectos(VentanaPrincipal padre) {

        // Caracteristicas de mi panel
        setLayout(new GridLayout(4,1));

        // Generamos los botones y les ponemos action listeners
        btonCrearProyecto = new JButton("CREAR NUEVO PROYECTO");
        btonCrearProyecto.setActionCommand(VentanaPrincipal.COMMANDO_CREAR_PROYECTO);
        btonCrearProyecto.addActionListener(padre);
        add(btonCrearProyecto);

        btonmodificarProyecto = new JButton("MODIFICAR PROYECTO SELECCIONADO");
        btonmodificarProyecto.setActionCommand(VentanaPrincipal.COMMANDO_MODIFICAR);
        btonmodificarProyecto.addActionListener(padre);
        add(btonmodificarProyecto);

        btonCrearActividad = new JButton("CREAR NUEVA ACTIVIDAD(Proyecto Seleccionado)");
        btonCrearActividad.setActionCommand(VentanaPrincipal.COMMANDO_CREAR_ACTIVIDAD);
        btonCrearActividad.addActionListener(padre);
        add(btonCrearActividad);

        btonCrearGraficos = new JButton("VER PORCENTAJES DE COMPLETACIÓN (Proyecto Seleccionado)");
        btonCrearGraficos.setActionCommand(VentanaPrincipal.COMMANDO_GRAFICOS);
        btonCrearGraficos.addActionListener(padre);
        add(btonCrearGraficos);


    }

}
