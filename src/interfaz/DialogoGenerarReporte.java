package interfaz;

import javax.swing.*;

import java.awt.BorderLayout;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.plaf.DimensionUIResource;

import modelo.Actividad;

public class DialogoGenerarReporte extends JDialog {

    private JList list;
    private JScrollPane scroller;

    DialogoGenerarReporte(HashMap<String, ArrayList<Actividad>> mapaProyectoActividades, String nombreMiembro) {
        setTitle("Reporte de Activida de " + nombreMiembro);
        setResizable(false);
        setSize(800, 650);

        // Crear la label
        JLabel lblScroll = new JLabel("Lista de Actividades");
        add(lblScroll, BorderLayout.NORTH);
        // Crear el scroller
        if (mapaProyectoActividades != null) {
            ArrayList<String> nombres = new ArrayList<String>();
            for (String nombreProyecto : mapaProyectoActividades.keySet()) {
                for (Actividad actividad : mapaProyectoActividades.get(nombreProyecto)) {
                    nombres.add(actividad.darTitulo() + "-" + actividad.darFecha().toString() + "-"
                            + actividad.darHoraInicio().toString() + "-" + actividad.darHoraFin().toString() + "-"
                            + nombreProyecto);
                }
            }

            String[] miLista = new String[nombres.size()];
            nombres.toArray(miLista);

            list = new JList<String>(miLista);
            list.setSelectedIndex(0);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scroller = new JScrollPane(list);
            scroller.setPreferredSize(new DimensionUIResource(475, 500));
            scroller.setWheelScrollingEnabled(true);

            add(scroller, BorderLayout.CENTER);
        } else {
            JLabel lblcaso = new JLabel("Ese usuario no tiene Actividades en proyectos a su nombre");
            add(lblcaso, BorderLayout.CENTER);
        }

        setVisible(true);
    }

}
