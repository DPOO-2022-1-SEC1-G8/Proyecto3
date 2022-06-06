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
import modelo.Actividad;;


public class PanelActividades extends JPanel{

    private JList listaTareas;
    private JScrollPane scrollerPaquetes;
    private JButton botonAgregarPaquete;

    public PanelActividades(VentanaPrincipal padre, List<Actividad> laListaActivdad){

        setSize(new DimensionUIResource(600, 230));
        setLayout(new GridLayout(1,2));

        JLabel labelListaPaquetes = new JLabel("Lista de Actividades");
        add(labelListaPaquetes, BorderLayout.NORTH);

        ArrayList<String> nombres = new ArrayList<String>();

        for (Actividad actividad : laListaActivdad) {
            nombres.add(actividad.darTitulo());
        }

        String[] miLista = new String[nombres.size()];
        nombres.toArray(miLista);


        listaTareas = new JList<String>(miLista);
        listaTareas.setSelectedIndex(0);
        listaTareas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollerPaquetes = new JScrollPane(listaTareas);
        scrollerPaquetes.setPreferredSize(new DimensionUIResource(250,150));
        add(scrollerPaquetes);

        botonAgregarPaquete = new JButton("Agregar Actividad");
        add(botonAgregarPaquete);

    }
    
    public String getSelection(){
        return (String) listaTareas.getSelectedValue();
    }
    
}
