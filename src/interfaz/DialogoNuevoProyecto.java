package interfaz;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class DialogoNuevoProyecto extends JDialog{

    private JButton btonCrearProyecto;
    private JButton btonAtras;
    private JTextField boxNombre;
    private JTextField boxDescripcion;
    private JTextField boxTipo;
    private JTextField boxInicio;
    private JTextField boxFinal;
    private JTextField boxMiembro;

    public DialogoNuevoProyecto(VentanaPrincipal padre){
        setTitle("Nuevo Proyecto");
		setResizable(false);
		setSize(575,500);

        // Organizacion de todos los paneles
        JPanel organizadorInfo = new JPanel(new GridLayout(1,2));
        JPanel organizadorBoton = new JPanel(new GridLayout(1,2));

        // Poner los botones
        btonAtras = new JButton("Atras");
        btonAtras.setActionCommand(VentanaPrincipal.COMMANDO_VENTANA_ATRAS_PROYECTO);
        btonAtras.addActionListener(padre);
        organizadorBoton.add(btonAtras);

        btonCrearProyecto= new JButton("Crear Proyecto");
        btonCrearProyecto.setActionCommand(VentanaPrincipal.COMMANDO_VENTANA_CREAR_PROYECTO);
        btonCrearProyecto.addActionListener(padre);
        organizadorBoton.add(btonCrearProyecto);

        // Ponemos las labels en la izquierda
        JPanel auxiliarIzquierda = new JPanel(new GridLayout(6,1));
        JLabel lblNombre = new JLabel(" Nombre ");
        auxiliarIzquierda.add(lblNombre);
        JLabel lblDescripcion = new JLabel(" Descripcion(Opcional) ");
        auxiliarIzquierda.add(lblDescripcion);
        JLabel lblTipo = new JLabel(" Tipo Actividad ");
        auxiliarIzquierda.add(lblTipo);
        JLabel lblInicio = new JLabel(" Fecha de Inicio (DD/MM/YYYY)");
        auxiliarIzquierda.add(lblInicio);
        JLabel lblFinal = new JLabel(" Fecha Finalizacion(Opcional) (DD/MM/YYYY)");
        auxiliarIzquierda.add(lblFinal);
        JLabel lblMiembro = new JLabel(" nombre de Miembro ");
        auxiliarIzquierda.add(lblMiembro);

        
        // Ponemos los text boxes a la derecha
        JPanel auxiliarDerecha = new JPanel(new GridLayout(6,1));
        boxNombre = new JTextField("");
        auxiliarDerecha.add(boxNombre);
        boxDescripcion = new JTextField("");
        auxiliarDerecha.add(boxDescripcion);
        boxTipo = new JTextField("");
        auxiliarDerecha.add(boxTipo);
        boxInicio = new JTextField("");
        auxiliarDerecha.add(boxInicio);
        boxFinal = new JTextField("");
        auxiliarDerecha.add(boxFinal);
        boxMiembro = new JTextField("");
        auxiliarDerecha.add(boxMiembro);

        organizadorInfo.add(auxiliarIzquierda);
        organizadorInfo.add(auxiliarDerecha);
        add(organizadorInfo,BorderLayout.CENTER);
        add(organizadorBoton,BorderLayout.SOUTH);
        setVisible(true);
    }

    public String ObtenerInformacionCampos(){
        // Metodo para devolver informacion de los campos(los devuelve )
        String respuesta = "";
        if(boxNombre.getText().equals("")){
            respuesta += "SinNombre";
        }else{
            respuesta += boxNombre.getText();
        }
        respuesta += ">";
        
        if(boxDescripcion.getText().equals("")){
            respuesta += "SinDescripcion";
        }else{
            respuesta += boxDescripcion.getText();
        }
        respuesta += ">";

        if(boxTipo.getText().equals("")){
            respuesta += "SinTipo";
        }else{
            respuesta += boxTipo.getText();
        }
        respuesta += ">";

        if(boxInicio.getText().equals("")){
            respuesta += "0";
        }else{
            respuesta += boxInicio.getText();
        }
        respuesta += ">";

        if(boxFinal.getText().equals("")){
            respuesta += "0";
        }else{
            respuesta += boxFinal.getText();
        }
        respuesta += ">";

        if(boxMiembro.getText().equals("")){
            respuesta += "SinNombre";
        }else{
            respuesta += boxMiembro.getText();
        }
        return respuesta;
    }

    public void CerrarDialogo() {
        setVisible(false);
        dispose();
    }

}