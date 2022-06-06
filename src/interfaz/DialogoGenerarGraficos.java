package interfaz;

import javax.swing.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.plaf.DimensionUIResource;

import org.knowm.xchart.*;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.pie.PieChart02;

import modelo.Actividad;
import modelo.PaqueteDeTrabajo;
import modelo.Tarea;

public class DialogoGenerarGraficos extends JDialog {

    private JList listaPaquetes;
    private JScrollPane scrollerPaquetes;
    private JButton botonAgregarPaquete;
    private PanelPaquetesDeTrabajo panelPaquetesDeTrabajo;
    private PanelTareas panelTareas;
    private PanelActividades panelActividades;
    
    DialogoGenerarGraficos(VentanaPrincipal padre, List<PaqueteDeTrabajo> laListaPaquetes, List<Tarea> laListaTarea, List<Actividad> laListaActividad){
        setTitle("Graficas extremadamente precisas");
        setResizable(false);
        setSize(800, 650);
        
        JPanel panelAuxiliarArriba = new JPanel();
        panelAuxiliarArriba.setLayout(new GridLayout(2,3));

        JPanel panelAuxiliarArribaIzquierda = new JPanel();
        JPanel panelAuxiliarCentro= new JPanel();
        JPanel panelAuxiliarAbajo = new JPanel();

        panelPaquetesDeTrabajo = new PanelPaquetesDeTrabajo(padre, laListaPaquetes);
        panelAuxiliarArribaIzquierda.add(panelPaquetesDeTrabajo);
        panelAuxiliarArriba.add(panelAuxiliarArribaIzquierda);

        panelTareas= new PanelTareas(padre, laListaTarea);
        panelAuxiliarCentro.add(panelTareas);
        
        panelActividades = new PanelActividades(padre, laListaActividad);
        panelAuxiliarAbajo.add(panelActividades);


        botonAgregarPaquete = new JButton("Agregar Paquete");
        botonAgregarPaquete.setActionCommand(VentanaPrincipal.COMMANDO_ANADIR_PAQUETES);
        botonAgregarPaquete.addActionListener(padre);
        panelAuxiliarArribaIzquierda.add(botonAgregarPaquete);

        
  

        add(panelAuxiliarArriba, BorderLayout.NORTH);
        add(panelAuxiliarCentro, BorderLayout.CENTER);
        add(panelAuxiliarAbajo, BorderLayout.SOUTH);
        
        setVisible(true);
    }


}
