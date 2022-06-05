package interfaz;

import javax.swing.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.plaf.DimensionUIResource;

import modelo.Actividad;
import modelo.PaqueteDeTrabajo;

public class PanelPaquetesDeTrabajo extends JPanel {
    private JList listaPaquetes;
    private JScrollPane scrollerPaquetes;
    private JButton botonAgregarPaquete;

    public PanelPaquetesDeTrabajo(VentanaPrincipal padre, List<PaqueteDeTrabajo> laListaPaquetes){

        setSize(new DimensionUIResource(600, 230));
        setLayout(new GridLayout(1,2));

        JLabel labelListaPaquetes = new JLabel("Lista de Paquetes de Trabajo");
        add(labelListaPaquetes, BorderLayout.NORTH);

        ArrayList<String> nombres = new ArrayList<String>();

        for (PaqueteDeTrabajo paqueteDeTrabajo : laListaPaquetes) {
            nombres.add(paqueteDeTrabajo.getNombre());
        }

        String[] miLista = new String[nombres.size()];
        nombres.toArray(miLista);


        listaPaquetes = new JList<String>(miLista);
        listaPaquetes.setSelectedIndex(0);
        listaPaquetes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollerPaquetes = new JScrollPane(listaPaquetes);
        scrollerPaquetes.setPreferredSize(new DimensionUIResource(250,150));
        add(scrollerPaquetes);

        botonAgregarPaquete = new JButton("Agregar Paquete");
        add(botonAgregarPaquete);

    }
    
    public String getSelection(){
        return (String) listaPaquetes.getSelectedValue();
    }
}
