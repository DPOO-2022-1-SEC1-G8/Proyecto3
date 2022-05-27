package interfaz;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import modelo.Miembro;

import java.awt.*;
import java.util.Map;

public class PanelMiembros extends JPanel{

    private PanelOpcionesMiembros panelOpciones;
    private PanelScrollMiembros panelScroll;

    public PanelMiembros(VentanaPrincipal padre, Map<String, Miembro> map){
            // Caracteristicas basicas de mi panel
            setSize(new DimensionUIResource(600, 230));
            setLayout(new GridLayout(1,2));
    
            // Generamos los Widgets que vamos a usar
            panelOpciones = new PanelOpcionesMiembros(padre);
            panelScroll = new PanelScrollMiembros(padre,map);
            
            // Agregamos los componentes al panel
            add(panelScroll);
            add(panelOpciones);
            
    }

    public void actualizarMiembros(VentanaPrincipal padre, Map<String, Miembro> elMapaMiembros) {
        remove(panelScroll);
        panelScroll = new PanelScrollMiembros(padre,elMapaMiembros);
        add(panelScroll);
        
    }

    public Object getpanelScrollList() {
        return panelScroll.getList();
    }

    public String getMiembroSeleccionado(){
        return panelScroll.getSelection();
    }
}
