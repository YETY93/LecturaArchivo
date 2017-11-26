package co.edu.uptc.lecturaArchivo.main;

import javafx.beans.property.SimpleStringProperty;

public class Persona {
	
	private SimpleStringProperty nombre;
	private SimpleStringProperty primerApellido;
	private SimpleStringProperty segundoApellido;
	private SimpleStringProperty cidudadNatal;
	private SimpleStringProperty genero;
	
	public Persona(String primNombre,String primApellido,String segunApellido,String ciuNatal,String genero ) {
		this.nombre = new SimpleStringProperty(primNombre);
		this.primerApellido = new SimpleStringProperty(primApellido);
		this.segundoApellido = new SimpleStringProperty(segunApellido);
		this.cidudadNatal = new SimpleStringProperty(ciuNatal);
		this.genero = new SimpleStringProperty(genero);
		
	}
	
	
	public String getNombre() {
		return nombre.get();
	}


	public void setNombre(String primNombre) {
		nombre.set(primNombre);
	}


	public String getPrimerApellido() {
		return primerApellido.get();
	}


	public void setPrimerApellido(String primNombre) {
		primerApellido.set(primNombre);
	}


	public String getSegundoApellido() {
		return segundoApellido.get();
	}


	public void setSegundoApellido(String primNombre) {
		segundoApellido.set(primNombre);
	}


	public String getCidudadNatal() {
		return cidudadNatal.get();
	}


	public void setCidudadNatal(String primNombre) {
		cidudadNatal.set(primNombre);
	}


	public String getGenero() {
		return genero.get();
	}


	public void setGenero(String primNombre) {
		genero.set(primNombre);
	}


	@Override
	public String toString() {
		return "Datos del Usuario [nombre=" + nombre + ", primerApellido=" + primerApellido+ ", segundoApellido="
				+ segundoApellido+ ", cidudadNatal=" + cidudadNatal + ", genero=" + genero + "]";
	}
	

	
	
	
}
