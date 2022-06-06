package interfaz;
import javax.swing.*;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.plaf.DimensionUIResource;

public class DialogoAnadirPaquete extends JDialog{
    JTextField boxNombre;
    JButton btonCrear;
    public DialogoAnadirPaquete(VentanaPrincipal padre){
        setTitle("Nuevo Paquete de Trabajo");
        setResizable(false);
        setSize(300,200);

        // Panel Auxiliar para poner el nombre y el correo
        JPanel panelAuxiliar = new JPanel();
        panelAuxiliar.setLayout(new GridLayout(1,2));

        // Panel Auxiliar Izquierdo para labels
        JPanel panelAxuliarIzquierdo= new JPanel();
        panelAxuliarIzquierdo.setLayout(new GridLayout(2,1));

        JLabel nombre = new JLabel("Nombre:");
        panelAxuliarIzquierdo.add(nombre);


        panelAuxiliar.add(panelAxuliarIzquierdo);

        // Panel Auxiliar Derecho para cuadros de texto
        JPanel panelAuxiliarDerecho = new JPanel();
        panelAuxiliarDerecho.setLayout(new GridLayout(2,1));

        boxNombre = new JTextField();
        boxNombre.setPreferredSize(new DimensionUIResource(100, 25));
        panelAuxiliarDerecho.add(boxNombre);

        panelAuxiliar.add(panelAuxiliarDerecho);

        add(panelAuxiliar,BorderLayout.CENTER);

        // Ponemos el boton
        btonCrear = new JButton("Crear");
        btonCrear.setActionCommand(VentanaPrincipal.COMMANDO_CREAR_PAQUETE);
        btonCrear.addActionListener(padre);
        add(btonCrear,BorderLayout.SOUTH);

        setVisible(true);

    }

    public String darBoxNombre(){
        return boxNombre.getText();
    }
    
}
