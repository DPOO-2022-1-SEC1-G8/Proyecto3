package modelo;
import java.util.ArrayList;
import java.util.Date ;
import java.util.List;

import javax.swing.event.ListDataEvent;
public class Tarea {
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean completado;
    private List<Actividad> listaActividades;

    public Tarea(String elNombre, String laDescripcion, Date laFechaInicio, Date laFechaFin){
        this.nombre =elNombre;
        this.descripcion = laDescripcion;
        this.fechaFin = laFechaFin;
        this.fechaInicio = laFechaInicio;
        this.listaActividades = new ArrayList<Actividad>();
        this.completado = false;
    }


    public int getCantidadActividades(){
        return listaActividades.size(); 
    }
    public List<Actividad> getActividades(){
        return listaActividades;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public Date getFechaInicio(){
        return fechaInicio;
    }

    public Date getFechaFin(){
        return fechaFin;
    }

    public void setNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }

    public void setDescripcion(String nuevaDescripcion){
        descripcion = nuevaDescripcion;
    }

    public void setListaActividades(Actividad laActividad){
        listaActividades.add(laActividad);
    }

    public boolean getCompletado(){
        return completado;
    }

    public double porcentajeCompletado(){
        
        int contador = 0;
        for (Actividad actividad : listaActividades) {
            if(actividad.getCompletado() == true){
                contador=contador+1;
            }
        }        
        double porcent = (contador/listaActividades.size())*100;
        
        return porcent;
    }

    public void setCompletado(){
        if(porcentajeCompletado() == 100){
            completado = true;
        }
    }

    public Miembro darMiembroUtil(){
        List<Miembro> listaMiembrosUtiles = new ArrayList<Miembro>();
        for (Actividad actividad : listaActividades) {
            if(actividad.getCompletado() == true)
            {
                listaMiembrosUtiles.add(actividad.darParticipante());
            }
        }
        int max = 0;
        Miembro masUtil = null;
        
        for (Miembro miembro : listaMiembrosUtiles) {
            int i=1;
            int contador = 0;
            while (i < listaMiembrosUtiles.size())
            {
                if(miembro == listaMiembrosUtiles.get(i))
                {
                    contador= contador+1;
                }
            }
            if(contador > max){
                max = contador;
                masUtil = miembro;
            }
        }

        return masUtil;
    }
}
