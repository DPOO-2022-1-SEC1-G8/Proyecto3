package interfaz;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.*;

public class PanelOpcionesMiembros extends JPanel {
    private JButton btonCrearMiembro;
    private JButton btonCronometrarActividad;
    private JButton btonGenerarReporteActividades;

    public PanelOpcionesMiembros(VentanaPrincipal padre) {

        // Caracteristicas de mi panel
        setLayout(new GridLayout(3,1));

        // Generamos los botones y les ponemos action listeners
        btonCrearMiembro = new JButton("CREAR UN NUEVO MIEMBRO");
        btonCrearMiembro.setActionCommand(VentanaPrincipal.COMMANDO_CREAR_Miembro);
        btonCrearMiembro.addActionListener(padre);
        add(btonCrearMiembro);

        btonCronometrarActividad = new JButton("CRONOMETRAR ACTIVIDAD");
        btonCronometrarActividad.setActionCommand(VentanaPrincipal.COMMANDO_CRONOMETRAR);
        btonCronometrarActividad.addActionListener(padre);
        add(btonCronometrarActividad);

        btonGenerarReporteActividades = new JButton("GENERAR REPORTE DE ACTIVIDADES");
        btonGenerarReporteActividades.setActionCommand(VentanaPrincipal.COMMANDO_REPORTE);
        btonGenerarReporteActividades.addActionListener(padre);
        add(btonGenerarReporteActividades);



    }

}
