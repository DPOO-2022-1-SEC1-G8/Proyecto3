package modelo;

public class Miembro {
	
	private String nombre;
	private String correo;
	
	public Miembro(String elNombre, String elCorreo) {
		this.nombre = elNombre;
		this.correo = elCorreo;
	}
	
	public String darNombre() {
		return nombre;
	}
	
	public String darCorreo() {
		return correo;
	}
	
}