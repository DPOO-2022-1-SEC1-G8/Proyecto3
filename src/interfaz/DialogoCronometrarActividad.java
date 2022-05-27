package interfaz;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;


import javax.swing.plaf.DimensionUIResource;


import java.time.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DialogoCronometrarActividad extends JDialog{
    private JTextField boxHora;
    private LocalTime tiempoInicio;
    private LocalTime tiempoActual;
    

    public DialogoCronometrarActividad(VentanaPrincipal padre){
        setTitle("Cronometrar Actividad");
        setResizable(false);
        setSize(500,150);
        
        //Panel Auxiliar para poner label y box
        JPanel panelAuxiliarTexto = new JPanel();
        panelAuxiliarTexto.setLayout(new GridLayout(1,2));

        JLabel tiempo = new JLabel("Tiempo:");
        panelAuxiliarTexto.add(tiempo);

        // Para crear la box necesitamos conocer la hora actual
        boxHora = new JTextField("Se actualiza cuando Pausas el cronometro");
        boxHora.setEditable(false);
        boxHora.setPreferredSize(new DimensionUIResource(200,50));

        panelAuxiliarTexto.add(boxHora);

        add(panelAuxiliarTexto,BorderLayout.CENTER);

        // Panel Botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1,2));

        JButton btonPausa = new JButton("Pausar");
        btonPausa.setActionCommand(VentanaPrincipal.COMMANDO_DIALOGO_PAUSAR_CRONOMETRO);
        btonPausa.addActionListener(padre);
        panelBotones.add(btonPausa);

        JButton btonInicio = new JButton("Comenzar");
        btonInicio.setActionCommand(VentanaPrincipal.COMMANDO_DIALOGO_INICIAR_CRONOMETRO);
        btonInicio.addActionListener(padre);
        panelBotones.add(btonInicio);

        add(panelBotones,BorderLayout.SOUTH);

        tiempoInicio = null;
        tiempoActual = null;
        setVisible(true);
        
    }

    public void PausarCronometroSegundos(){
        int solucion = 0;
        try{tiempoActual = LocalTime.now();
            solucion = (int)Duration.between(tiempoInicio,tiempoActual ).getSeconds();
        }
        finally{
            int hours = solucion / 3600;
            int minutes = (solucion % 3600) / 60;
            int seconds = solucion % 60;

            String solucionTxt = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            boxHora.setText("El tiempo total transcurrido fue "+ solucionTxt);
        }

    }

    public void iniciarCronometro(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        tiempoInicio = LocalTime.now();
        boxHora.setText("La hora de inicio es:"+ dtf.format(tiempoInicio));
    }


    
}
