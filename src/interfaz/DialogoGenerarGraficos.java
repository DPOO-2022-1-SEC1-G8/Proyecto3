package interfaz;

import javax.swing.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.plaf.DimensionUIResource;

import modelo.Actividad;
import modelo.PaqueteDeTrabajo;

public class DialogoGenerarGraficos extends JDialog {

    private JList listaPaquetes;
    private JScrollPane scrollerPaquetes;
    private JButton botonAgregarPaquete;
    
    DialogoGenerarGraficos(List<PaqueteDeTrabajo> laListaPaquetes){
        setTitle("Graficas extremadamente precisas");
        setResizable(false);
        setSize(800, 650);
        
        JPanel panelAuxiliarArriba = new JPanel();
        panelAuxiliarArriba.setLayout(new GridLayout(2,3));

        JPanel panelAuxiliarArribaIzquierda = new JPanel();

        JLabel labelListaPaquetes = new JLabel("Lista de Paquetes de Trabajo");
        panelAuxiliarArribaIzquierda.add(labelListaPaquetes, BorderLayout.NORTH);

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
        panelAuxiliarArribaIzquierda.add(scrollerPaquetes, BorderLayout.WEST);

        botonAgregarPaquete = new JButton("Agregar Paquete");
        panelAuxiliarArribaIzquierda.add(botonAgregarPaquete, BorderLayout.SOUTH);

        panelAuxiliarArriba.add(panelAuxiliarArribaIzquierda);
        add(panelAuxiliarArriba, BorderLayout.NORTH);
        setVisible(true);
    }
}
