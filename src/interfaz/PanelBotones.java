package interfaz;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import java.awt.GridLayout;

public class PanelBotones extends JPanel{
    private JButton botonGuardar;
    private JButton botonGuardarCerrar;

    public PanelBotones(VentanaPrincipal padre){
        // Caracteristicas basicas de mi Panel
        setSize(new DimensionUIResource(600, 80));
        setLayout(new GridLayout(1,2));

        // Generacion de botones
        botonGuardar = new JButton("GUARDAR");
        botonGuardar.setSize(new DimensionUIResource(250, 60));
        botonGuardar.setActionCommand(VentanaPrincipal.COMMANDO_GUARDAR); // Comando que vamos a guardar, no es un import pq es public
        botonGuardar.addActionListener(padre);
        add(botonGuardar);

        botonGuardarCerrar = new JButton("GUARDAR & CERRAR");
        botonGuardarCerrar.setSize(new DimensionUIResource(250, 60));
        botonGuardarCerrar.setActionCommand(VentanaPrincipal.COMMANDO_GUARDAR_CERRAR); // Comando que vamos a guardar, no es un import pq es public
        botonGuardarCerrar.addActionListener(padre);
        add(botonGuardarCerrar);
    }

}
