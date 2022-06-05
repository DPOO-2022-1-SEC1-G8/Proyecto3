package modelo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaqueteDeTrabajo{

    private String nombre; 
    private List<Tarea> listaTareas;
    private boolean completado;

    public PaqueteDeTrabajo(String elNombre){
        this.nombre = elNombre;
        this.listaTareas = new ArrayList<Tarea>();
        this.completado = false;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean getCompletado(){
        return completado;
    }

    public int getCantidadTareas(){
        return listaTareas.size();
    }

    public List<Tarea> getListaTareas(){
        return listaTareas;
    }

    public void setNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }
    
    public void setListaTareas(Tarea laTarea){
        listaTareas.add(laTarea);
    }

    public double getPorcentajeCompletado(){
        int contador = 0;
        for (Tarea tarea : listaTareas) {
            if(tarea.getCompletado() == true){
                contador = contador+1;
            }
        }
        double percent = (contador/listaTareas.size())*100;
        return percent;
    }

    public void setCompletado(){
        if(getPorcentajeCompletado() == 100){
            completado = true;
        }
    }

    public Miembro miembroMasUtil(){
        List<Miembro> listaMiembroUtiles = new ArrayList<Miembro>();
        for (Tarea tarea : listaTareas) {
            listaMiembroUtiles.add(tarea.darMiembroUtil());
        }

        int max=0;
        Miembro elUtil= null;

        for (Miembro miembro : listaMiembroUtiles) {
            int contador= 0;
            int i =1;
            while(i < listaMiembroUtiles.size())
            {
                if(miembro == listaMiembroUtiles.get(i))
                {
                    contador = contador+1;
                }
            }
            if(contador > max){
                max = contador;
                elUtil = miembro;
            }
        }
        return elUtil;
    }

}