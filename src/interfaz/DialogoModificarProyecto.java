package interfaz;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import modelo.Proyecto;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.DimensionUIResource;

import modelo.Actividad;
import modelo.Miembro;

public class DialogoModificarProyecto extends JDialog{

    private JPanel panelActividades;
    private JPanel panelParticipantes;
    private JList listaActividades;
    private JScrollPane scrollerActividades;
    private JTextField boxFechaFinal;
    private JButton btonModificarFecha;
    private JList listaParticipantes;
    private JScrollPane scrollerParticipantes;
    private JTextField boxAgregarParticipante;
    private JButton btonAgregarParticipante;


    public DialogoModificarProyecto(VentanaPrincipal padre , Proyecto elProyecto){
        setTitle("Modificar Proyecto");
		setResizable(false);
		setSize(575,450);
        setLayout(new GridLayout(2,1));

        panelActividades = new JPanel(new GridLayout(1,2));

        // Generacion de panel Auxiliar Izquierdo
        JPanel panelAuxiliarIzqAct = new JPanel();


        JLabel labelScroll = new JLabel(" LISTA DE ACTIVIDADES ");
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        labelScroll.setBorder(border);
        panelAuxiliarIzqAct.add(labelScroll, BorderLayout.NORTH);

        // Generador de la lista
        List<Actividad> actividades = elProyecto.darListaActividades();
        ArrayList<String> nombres = new ArrayList<String>();

		for (Actividad miActividad: actividades) {
            nombres.add(miActividad.darTitulo());
		}
        
        String[] miLista= new String[ nombres.size() ];
        nombres.toArray( miLista);

        listaActividades = new JList<String>(miLista);
        listaActividades.setSelectedIndex(0);
        listaActividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollerActividades = new JScrollPane(listaActividades);
        scrollerActividades.setPreferredSize(new DimensionUIResource(250,140));
        scrollerActividades.setWheelScrollingEnabled(true);
        panelAuxiliarIzqAct.add(scrollerActividades, BorderLayout.CENTER);

        JButton BtonModificarActividad = new JButton("Modifciar Actividad");
        BtonModificarActividad.setActionCommand(VentanaPrincipal.COMMANDO_DIALOGO_MODIFICAR_ACTIVIDAD_SELECT);
        BtonModificarActividad.addActionListener(padre);
        panelAuxiliarIzqAct.add(BtonModificarActividad,BorderLayout.SOUTH);

        panelActividades.add(panelAuxiliarIzqAct);

        // Generacion de panel Auxiliar Derecho
        JPanel panelAuxiliarDerAct = new JPanel();

        JLabel lblFechaOriginal = new JLabel("Fecha Original: "+ elProyecto.darFechaFin().toString());
        panelAuxiliarDerAct.add(lblFechaOriginal,BorderLayout.NORTH);

        JLabel textoFecha = new JLabel("Nueva Fecha de Finalizacion:");
        panelAuxiliarDerAct.add(textoFecha,BorderLayout.NORTH);

        boxFechaFinal = new JTextField("(DD/MM/YYYY)");
        boxFechaFinal.setPreferredSize(new Dimension(250,50));
        panelAuxiliarDerAct.add(boxFechaFinal,BorderLayout.CENTER);



        btonModificarFecha = new JButton("Modificar Fecha de Finalizacion");
        btonModificarFecha.setActionCommand(VentanaPrincipal.COMMANDO_DIALOGO_MODIFICAR_FINALIZACION);
        btonModificarFecha.addActionListener(padre);
        panelAuxiliarDerAct.add(btonModificarFecha,BorderLayout.SOUTH);

        panelActividades.add(panelAuxiliarDerAct);
        add(panelActividades);


        // Generacion del panel de abajo

        panelParticipantes = new JPanel(new GridLayout(1,2));

        JPanel panelAuxiliarParIzq = new JPanel();

        JLabel labelScrollPart = new JLabel(" LISTA DE PARTICIPANTES ");
        Border borderpart = BorderFactory.createLineBorder(Color.BLACK, 1);
        labelScrollPart.setBorder(borderpart);
        panelAuxiliarParIzq.add(labelScrollPart, BorderLayout.NORTH);


        // Generador de la lista
        List<Miembro> miembros = elProyecto.darListaParticipantes();
        ArrayList<String> nombresMiembros = new ArrayList<String>();

		for (Miembro miMiembro: miembros) {
            nombresMiembros.add(miMiembro.darNombre());
		}
        
        String[] miLista2= new String[ nombresMiembros.size() ];
        nombresMiembros.toArray( miLista2);

        listaParticipantes = new JList<String>(miLista2);
        listaParticipantes.setSelectedIndex(0);
        listaParticipantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollerParticipantes = new JScrollPane(listaParticipantes);
        scrollerParticipantes.setPreferredSize(new DimensionUIResource(250,150));
        scrollerParticipantes.setWheelScrollingEnabled(true);
        panelAuxiliarParIzq.add(scrollerParticipantes, BorderLayout.CENTER);

        panelParticipantes.add(panelAuxiliarParIzq);

        // Panel Auxiliar de la derecha
        JPanel panelAuxiliarParDer = new JPanel();

        JLabel textoMiembro = new JLabel("Nombre del Miembro");
        panelAuxiliarParDer.add(textoMiembro,BorderLayout.NORTH);

        boxAgregarParticipante = new JTextField();
        boxAgregarParticipante.setPreferredSize(new Dimension(250,50));
        panelAuxiliarParDer.add(boxAgregarParticipante,BorderLayout.CENTER);

        btonAgregarParticipante = new JButton("Agregar Participante");
        btonAgregarParticipante.setActionCommand(VentanaPrincipal.COMMANDO_DIALOGO_AGREGAR_PARTICIPANTE);
        btonAgregarParticipante.addActionListener(padre);
        panelAuxiliarParDer.add(btonAgregarParticipante,BorderLayout.SOUTH); 

        panelParticipantes.add(panelAuxiliarParDer);
        add(panelParticipantes);

        setVisible(true);
    }
    

    public String darBoxFechaFinal(){
        return boxFechaFinal.getText();
    }

    public String darBoxNombreMiembro(){
        return boxAgregarParticipante.getText();
    }

    public String darNombreActividadActual(){
        return (String) listaActividades.getSelectedValue();
    };

    public void CerrarDialogo() {
        setVisible(false);
        dispose();
    }

}
