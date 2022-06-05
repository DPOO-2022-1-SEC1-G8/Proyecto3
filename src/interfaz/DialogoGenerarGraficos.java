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
    //private PanelPaquetesDeTrabajo panelPaquetesDeTrabajo;
    
    DialogoGenerarGraficos(VentanaPrincipal padre, List<PaqueteDeTrabajo> laListaPaquetes){
        setTitle("Graficas extremadamente precisas");
        setResizable(false);
        setSize(800, 650);
        
        JPanel panelAuxiliarArriba = new JPanel();
        panelAuxiliarArriba.setLayout(new GridLayout(2,3));

        JPanel panelAuxiliarArribaIzquierda = new JPanel();

        //panelPaquetesDeTrabajo = new PanelPaquetesDeTrabajo(padre, laListaPaquetes);
        //panelAuxiliarArribaIzquierda.add(panelPaquetesDeTrabajo);
        panelAuxiliarArriba.add(panelAuxiliarArribaIzquierda);
        
        add(panelAuxiliarArriba, BorderLayout.NORTH);
        setVisible(true);
    }


}
