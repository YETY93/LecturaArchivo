package co.edu.uptc.lecturaArchivo.main;

public class DatosUsuario {
	
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String cidudadNatal;
	private String genero;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getCidudadNatal() {
		return cidudadNatal;
	}
	public void setCidudadNatal(String cidudadNatal) {
		this.cidudadNatal = cidudadNatal;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Datos del Usuario [nombre=" + nombre + ", primerApellido=" + primerApellido+ ", segundoApellido="
				+ segundoApellido+ ", cidudadNatal=" + cidudadNatal + ", genero=" + genero + "]";
	}
	
	
	
	
	
}
