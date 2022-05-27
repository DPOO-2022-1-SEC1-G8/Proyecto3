package interfaz;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.DimensionUIResource;

import modelo.Miembro;

public class DialogoNuevaActividad extends JDialog {

    private JList listaParticipantes;
    private JScrollPane scrollerParticipantes;
    private JList listaTipos;
    private JScrollPane scrollerTipos;

    private JTextField boxNombre;
    private JTextField boxDescripcion;
    private JTextField boxTipo;
    private JTextField boxFecha;
    private JTextField boxInicio;
    private JTextField boxFin;
    private JTextField boxNombreMiembro;

    private JButton btonCrearActividad;


    public DialogoNuevaActividad(VentanaPrincipal padre,List<Miembro> participantes, List<String> tiposDeActividad){
        setTitle("Nueva Actividad");
        setResizable(false);
        setSize(575,450);
        
        // Paneles auxiliares de organizacion arriba
        JPanel panelAuxiliarArriba = new JPanel();
        panelAuxiliarArriba.setLayout(new GridLayout(1,2));

        // Panel Auxiliar Arriba Izquierda
        
        JPanel PanelAuxiliarArribaIzquierda = new JPanel();

        JLabel labelListaParticipantes = new JLabel("Lista Participantes");
        PanelAuxiliarArribaIzquierda.add(labelListaParticipantes,BorderLayout.NORTH);

        ArrayList<String> nombres = new ArrayList<String>();

		for (Miembro participante: participantes) {
            nombres.add(participante.darNombre());
		}
        
        String[] miLista= new String[ nombres.size() ];
        nombres.toArray( miLista);

        listaParticipantes = new JList<String>(miLista);
        listaParticipantes.setSelectedIndex(0);
        listaParticipantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollerParticipantes = new JScrollPane(listaParticipantes);
        scrollerParticipantes.setPreferredSize(new DimensionUIResource(250,150));
        PanelAuxiliarArribaIzquierda.add(scrollerParticipantes, BorderLayout.CENTER);

        panelAuxiliarArriba.add(PanelAuxiliarArribaIzquierda);

        // Panel Auxiliar Arriba Derecha
        JPanel PanelAuxiliarArribaDerecha = new JPanel();

        JLabel labelListaTipos = new JLabel("Lista Tipos de Actividad");
        PanelAuxiliarArribaDerecha.add(labelListaTipos,BorderLayout.NORTH);

        ArrayList<String> nombres2 = new ArrayList<String>();

		for (String tipo: tiposDeActividad) {
            nombres2.add(tipo);
		}
        
        String[] miLista2= new String[ nombres2.size() ];
        nombres2.toArray( miLista2);

        listaTipos = new JList<String>(miLista2);
        listaTipos.setSelectedIndex(0);
        listaTipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollerTipos = new JScrollPane(listaTipos);
        scrollerTipos.setPreferredSize(new DimensionUIResource(250,150));
        PanelAuxiliarArribaDerecha.add(scrollerTipos, BorderLayout.CENTER);

        panelAuxiliarArriba.add(PanelAuxiliarArribaDerecha);

        add(panelAuxiliarArriba,BorderLayout.NORTH);

        // Panel Auxiliar de Medio

        JPanel panelAuxiliarMedio = new JPanel();
        panelAuxiliarMedio.setLayout(new GridLayout(1,2));

        // Panel Auxiliar Medio Izquierda
        JPanel panelAuxiliarMedioIzquierda = new JPanel();
        panelAuxiliarMedioIzquierda.setLayout(new GridLayout(7,1));

        JLabel nombre = new JLabel("Nombre");
        panelAuxiliarMedioIzquierda.add(nombre);
        
        JLabel descripcion = new JLabel("Descripcion (Opcional)");
        panelAuxiliarMedioIzquierda.add(descripcion);
        
        JLabel tipo = new JLabel("Tipo de Actividad");
        panelAuxiliarMedioIzquierda.add(tipo);
        
        JLabel fecha = new JLabel("Fecha de Realizacion(DD,MM,YYYY)");
        panelAuxiliarMedioIzquierda.add(fecha);
        
        JLabel horaInicial = new JLabel("Hora de Inicio(SS:MM:HH)");
        panelAuxiliarMedioIzquierda.add(horaInicial);
        
        JLabel horaFinal = new JLabel("Hora de Finalizacion(SS:MM:HH)");
        panelAuxiliarMedioIzquierda.add(horaFinal);

        JLabel nombreMimebro = new JLabel("Nombre del Miembro");
        panelAuxiliarMedioIzquierda.add(nombreMimebro);

        panelAuxiliarMedio.add(panelAuxiliarMedioIzquierda);

        // Panel Auxiliar Medio Derecha
        JPanel panelAuxiliarMedioDerecha = new JPanel();
        panelAuxiliarMedioDerecha.setLayout(new GridLayout(7,1));

        boxNombre = new JTextField();
        boxNombre.setPreferredSize(new DimensionUIResource(100, 25));
        panelAuxiliarMedioDerecha.add(boxNombre);

        boxDescripcion = new JTextField();
        boxDescripcion.setPreferredSize(new DimensionUIResource(100, 25));
        panelAuxiliarMedioDerecha.add(boxDescripcion);
        
        boxTipo = new JTextField();
        boxTipo.setPreferredSize(new DimensionUIResource(100, 25));
        panelAuxiliarMedioDerecha.add(boxTipo);

        boxFecha = new JTextField();
        boxFecha.setPreferredSize(new DimensionUIResource(100, 25));
        panelAuxiliarMedioDerecha.add(boxFecha);

        boxInicio = new JTextField();
        boxInicio.setPreferredSize(new DimensionUIResource(100, 25));
        panelAuxiliarMedioDerecha.add(boxInicio);

        boxFin = new JTextField();
        boxFin.setPreferredSize(new DimensionUIResource(100, 25));
        panelAuxiliarMedioDerecha.add(boxFin);

        boxNombreMiembro = new JTextField();
        boxNombreMiembro.setPreferredSize(new DimensionUIResource(100, 25));
        panelAuxiliarMedioDerecha.add(boxNombreMiembro);

        panelAuxiliarMedio.add(panelAuxiliarMedioDerecha);

        add(panelAuxiliarMedio,BorderLayout.CENTER);

        // Agregamos el boton al south

        btonCrearActividad = new JButton("Crear");
        btonCrearActividad.setActionCommand(VentanaPrincipal.COMMMANDO_DIALOGO_CREAR_ACTIVIDAD);
        btonCrearActividad.addActionListener(padre);
        add(btonCrearActividad,BorderLayout.SOUTH);

        setVisible(true);

    }

    public String getBoxNombre(){
        return boxNombre.getText();
    }
    
    public String getBoxDescripcion(){
        return boxDescripcion.getText();
    }
    
    public String getBoxTipo(){
        return boxTipo.getText();
    }
    
    public String getBoxFecha(){
        return boxFecha.getText();
    }
    
    public String getBoxInicio(){
        return boxInicio.getText();
    }
    
    public String getBoxFin(){
        return boxFin.getText();
    }
    
    public String getBoxNombreMiembro(){
        return boxNombreMiembro.getText();
    }

    public void CerrarDialogo() {
        setVisible(false);
        dispose();
    }

    
}
