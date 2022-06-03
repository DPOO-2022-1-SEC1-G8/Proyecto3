package modelo;

public class Actividad {
	private String titulo;
	private String descripcion;
	private String tipo;
	private Miembro participante;
	private java.util.Date fecha;
	private java.util.Date horaInicio;
	private java.util.Date horaFin;
	private boolean completado;
	
	public Actividad(String elTitulo, String laDescripcion, String elTipo, Miembro elParticipante,
					java.util.Date laFecha, java.util.Date laHoraInicio, java.util.Date laHoraFin) {
		this.titulo = elTitulo;
		this.descripcion = laDescripcion;
		this.tipo = elTipo;

		if(elParticipante == null){
			this.participante = new Miembro("Null","Null");
		}else{
			this.participante = elParticipante;
		}
		this.fecha = laFecha;
		this.horaInicio = laHoraInicio;
		this.horaFin = laHoraFin;
		this.completado = false;

	}
	
	public String darTitulo() {
		return titulo;
	}
	
	public String darDescripcion() {
		return descripcion;
	}
	
	public String darTipo() {
		return tipo;
	}
	
	public Miembro darParticipante() {
		return participante;
	}
	
	public java.util.Date darFecha() {
		return fecha;
	}
	
	public java.util.Date darHoraInicio() {
		return horaInicio;
	}
	
	public java.util.Date darHoraFin() {
		return horaFin;
	}
	
	public void modificarFecha(java.util.Date nuevaFecha) {
		this.fecha = nuevaFecha;
	}
	
	public void modificarHoraInicio(java.util.Date nuevaHoraInicio) {
		this.horaInicio = nuevaHoraInicio;
	}
	
	public void modificarHoraFin(java.util.Date nuevaHoraFin) {
		this.horaFin = nuevaHoraFin;
	}

	public boolean getCompletado(){
		return completado;
	}
	public void setCompletado(boolean estado){
		completado = estado;
	}
}