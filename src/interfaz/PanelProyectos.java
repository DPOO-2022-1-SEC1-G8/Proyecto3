package interfaz;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import modelo.Proyecto;

import java.awt.*;
import java.util.Map;

public class PanelProyectos extends JPanel{

    private PanelOpcionesProyectos panelOpciones;
    private PanelScrollProyectos panelScroll;

    public PanelProyectos(VentanaPrincipal padre, Map<String, Proyecto> map){
        // Caracteristicas basicas de mi panel
        setSize(new DimensionUIResource(600, 230));
        setLayout(new GridLayout(1,2));

        // Generamos los Widgets que vamos a usar
        panelOpciones = new PanelOpcionesProyectos(padre);
        panelScroll = new PanelScrollProyectos(padre,map);
        
        // Agregamos los componentes al panel
        add(panelScroll);
        add(panelOpciones);
        
    }

    public void actualizarProyectos(VentanaPrincipal padre ,Map<String, Proyecto> elMapaProyectos) {
        remove(panelScroll);
        panelScroll = new PanelScrollProyectos(padre,elMapaProyectos);
        add(panelScroll);
    }
    public String getSelection(){
        return panelScroll.getSelection();
    }
}
