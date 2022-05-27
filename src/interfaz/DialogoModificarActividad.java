package interfaz;

import javax.swing.JDialog;
import javax.swing.*;

import java.awt.GridLayout;


import java.awt.Dimension;


import modelo.Actividad;


public class DialogoModificarActividad extends JDialog{
    JTextField boxFecha;
    JTextField boxInicio;
    JTextField boxFin;
    public DialogoModificarActividad(VentanaPrincipal padre,Actividad laActividad){
        setTitle("Modificar Proyecto");
		setResizable(false);
		setSize(575,350);
        setLayout(new GridLayout(1,3));

        // Labels:
        JPanel panelAxiliarIzq = new JPanel(new GridLayout(3,1));
        JLabel labelFecha = new JLabel("Fecha de Realizacion");
        JLabel labelHoraInicio = new JLabel("Hora de Inicio");
        JLabel labelHoraFin = new JLabel("Hora de Finalizacion");
        panelAxiliarIzq.add(labelFecha);
        panelAxiliarIzq.add(labelHoraInicio);
        panelAxiliarIzq.add(labelHoraFin);

        // Cuadros de texto
        JPanel panelAuxiliarCentro = new JPanel(new GridLayout(3,1));
        boxFecha = new JTextField();
        boxFecha.setPreferredSize(new Dimension(250,25));
        panelAuxiliarCentro.add(boxFecha);

        boxInicio= new JTextField();
        boxInicio.setPreferredSize(new Dimension(250,25));
        panelAuxiliarCentro.add(boxInicio);

        boxFin= new JTextField();
        boxFin.setPreferredSize(new Dimension(250,25));
        panelAuxiliarCentro.add(boxFin);

        // Botones
        JPanel panelAuxiliarDerecha = new JPanel(new GridLayout(3,1));

        JButton btonModificarFecha = new JButton("Modificar Fecha de Realizacion");
        btonModificarFecha.setActionCommand(VentanaPrincipal.COMMANDO_DIALOGO_ACTIVIDAD_FECHA);
        btonModificarFecha.addActionListener(padre);
        panelAuxiliarDerecha.add(btonModificarFecha);

        JButton btonModificarInicio = new JButton("Modificar Hora de Inicio");
        btonModificarInicio.setActionCommand(VentanaPrincipal.COMMANDO_DIALOGO_ACTIVIDAD_HORA_INICIO);
        btonModificarInicio.addActionListener(padre);
        panelAuxiliarDerecha.add(btonModificarInicio);

        JButton btonModificarFinal = new JButton("Modificar Fecha de Realizacion");
        btonModificarFinal.setActionCommand(VentanaPrincipal.COMMANDO_DIALOGO_ACTIVIDAD_HORA_FINAL);
        btonModificarFinal.addActionListener(padre);
        panelAuxiliarDerecha.add(btonModificarFinal);

        add(panelAxiliarIzq);
        add(panelAuxiliarCentro);
        add(panelAuxiliarDerecha);
        
        setVisible(true);
    } 


    public void CerrarDialogo() {
        setVisible(false);
        dispose();
    }

}
