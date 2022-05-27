package interfaz;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.plaf.DimensionUIResource;

public class DialogoCrearMiembro extends JDialog{
    JTextField boxNombre;
    JTextField boxCorreo;
    JButton btonCrear;
    public DialogoCrearMiembro(VentanaPrincipal padre){

        setTitle("Nueva Miembro");
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

        JLabel correo = new JLabel("Correo:");
        panelAxuliarIzquierdo.add(correo);

        panelAuxiliar.add(panelAxuliarIzquierdo);

        // Panel Auxiliar Derecho para cuadros de texto
        JPanel panelAuxiliarDerecho = new JPanel();
        panelAuxiliarDerecho.setLayout(new GridLayout(2,1));

        boxNombre = new JTextField();
        boxNombre.setPreferredSize(new DimensionUIResource(100, 25));
        panelAuxiliarDerecho.add(boxNombre);

        boxCorreo = new JTextField();
        boxCorreo.setPreferredSize(new DimensionUIResource(100, 25));
        panelAuxiliarDerecho.add(boxCorreo);

        panelAuxiliar.add(panelAuxiliarDerecho);

        add(panelAuxiliar,BorderLayout.CENTER);

        // Ponemos el boton
        btonCrear = new JButton("Crear");
        btonCrear.setActionCommand(VentanaPrincipal.COMMMANDO_DIALOGO_CREAR_MIEMBRO);
        btonCrear.addActionListener(padre);
        add(btonCrear,BorderLayout.SOUTH);

        setVisible(true);
    }


    public String darBoxNombre(){
        return boxNombre.getText();
    }
    public String darBoxCorreo(){
        return boxCorreo.getText();
    }
}
