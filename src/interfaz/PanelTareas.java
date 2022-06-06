package interfaz;

import javax.swing.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.plaf.DimensionUIResource;

import modelo.Actividad;
import modelo.PaqueteDeTrabajo;
import modelo.Tarea;

public class PanelTareas extends JPanel{

    private JList listaTareas;
    private JScrollPane scrollerPaquetes;
    private JButton botonAgregarPaquete;

    public PanelTareas(VentanaPrincipal padre, List<Tarea> laListaTarea){

        setSize(new DimensionUIResource(600, 230));
        setLayout(new GridLayout(1,2));

        JLabel labelListaPaquetes = new JLabel("Lista de Tareas");
        add(labelListaPaquetes, BorderLayout.NORTH);

        ArrayList<String> nombres = new ArrayList<String>();

        for (Tarea tarea : laListaTarea) {
            nombres.add(tarea.getNombre());
        }

        String[] miLista = new String[nombres.size()];
        nombres.toArray(miLista);


        listaTareas = new JList<String>(miLista);
        listaTareas.setSelectedIndex(0);
        listaTareas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollerPaquetes = new JScrollPane(listaTareas);
        scrollerPaquetes.setPreferredSize(new DimensionUIResource(250,150));
        add(scrollerPaquetes);

        botonAgregarPaquete = new JButton("Agregar Tarea");
        add(botonAgregarPaquete);

    }
    
    public String getSelection(){
        return (String) listaTareas.getSelectedValue();
    }
    
}
