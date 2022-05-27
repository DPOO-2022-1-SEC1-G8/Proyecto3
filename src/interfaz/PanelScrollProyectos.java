package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import java.util.Map;

import javax.swing.border.Border;

import javax.swing.*;

import javax.swing.plaf.DimensionUIResource;

import modelo.Proyecto;

public class PanelScrollProyectos extends JPanel {
    private JLabel labelScroll;
    private JScrollPane scroller;
    private JList list;

    public PanelScrollProyectos(VentanaPrincipal padre,Map<String, Proyecto> map) {
        labelScroll = new JLabel(" LISTA DE PROYECTOS ");
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        labelScroll.setBorder(border);
        add(labelScroll, BorderLayout.NORTH);

        // Generador de la lista
        ArrayList<String> nombres = new ArrayList<String>();
		for (String nombreProyecto: map.keySet()) {
            nombres.add(nombreProyecto);
		}

        String[] miLista= new String[ nombres.size() ];
        nombres.toArray( miLista);
        

        list = new JList<String>(miLista);
        list.setSelectedIndex(0);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scroller = new JScrollPane(list);
        list.addListSelectionListener(padre);
        scroller.setPreferredSize(new DimensionUIResource(300,240));
        scroller.setWheelScrollingEnabled(true);
        add(scroller, BorderLayout.SOUTH);
    }

    public String getSelection() {
        return (String) list.getSelectedValue();
    }


}