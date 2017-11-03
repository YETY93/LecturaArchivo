package co.edu.uptc.lecturaArchivo.ctr;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL; 
import java.util.ResourceBundle;

import co.edu.uptc.lecturaArchivo.main.DatosUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CtrDatosPersonales implements Initializable {
	
	
	
		@FXML
		private TextField txtNombre;
		@FXML
		private TextField txtApellidoUno;
		@FXML
		private TextField txtApellidoDos;
		@FXML
		private TextField txtNatalidad;
		@FXML
		private TextField txtGenero;
		@FXML
		private Button guardar;
		@FXML
		private Button capturaInformacion;
		@FXML
		private TextArea areaTexto;
		
	
	public void GuardarDatos(ActionEvent event) {
		try {
		DatosUsuario nuevo1 = new DatosUsuario();
		nuevo1.setNombre(txtNombre.getText());
		nuevo1.setPrimerApellido(txtApellidoUno.getText());
		nuevo1.setSegundoApellido(txtApellidoDos.getText());
		nuevo1.setCidudadNatal(txtNatalidad.getText());
		nuevo1.setGenero(txtGenero.getText());


		File datos;
		FileWriter escritura;
		BufferedWriter bufferEscritura;
		PrintWriter escribirArchivo;
		
	
			datos = new File("C:\\Users\\Usuario\\Desktop\\datosUsario.txt");
			escritura = new FileWriter(datos);
			bufferEscritura = new BufferedWriter(escritura);
			escribirArchivo = new PrintWriter(bufferEscritura);
			
			escribirArchivo.write(nuevo1.getNombre().toUpperCase());
			escribirArchivo.append(" | " + nuevo1.getPrimerApellido().toUpperCase());
			escribirArchivo.append(" | " + nuevo1.getSegundoApellido().toUpperCase());
			escribirArchivo.append(" | " + nuevo1.getCidudadNatal().toUpperCase());
			escribirArchivo.append(" | " + nuevo1.getGenero().toUpperCase());
			
			escribirArchivo.close();
			bufferEscritura.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void mostarDatos(ActionEvent event) {
		
		File datosMostrar;
		FileReader lecturaDatos;
		BufferedReader buferLectura;
		
		try {
			
			datosMostrar = new File("C:\\Users\\Usuario\\Desktop\\datosUsario.txt");
			lecturaDatos = new FileReader(datosMostrar);
			buferLectura = new BufferedReader(lecturaDatos);
			
			String informacion;
			while((informacion = buferLectura.readLine() )!=null ) {
				areaTexto.setText(informacion);
			}
			buferLectura.close();
			lecturaDatos.close();
			

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
		
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
