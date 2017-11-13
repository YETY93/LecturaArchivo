package co.edu.uptc.lecturaArchivo.ctr;

import java.io.FileNotFoundException;
import java.net.URL; 
import java.util.ResourceBundle;

import co.edu.uptc.lecturaArchivo.main.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CtrDatosPersonales implements Initializable {
	
	
		@FXML
		private TextField	txtNombArchivo;
		@FXML
		private TextField 	txtNombre;
		@FXML
		private TextField 	txtApellidoUno;
		@FXML
		private TextField	txtApellidoDos;
		@FXML
		private TextField	txtNatalidad;
		@FXML
		private TextField	txtGenero;
		@FXML
		private Button		guardar;
		@FXML
		private Button 		capturaInformacion;
		@FXML
		private TextArea 	areaTexto;
		
	
	public void GuardarDatos(ActionEvent event) {
		try {
					
			// creacion de obejo persona y la escritura de archivo
			
		Persona 		nuevaPerso 	= new Persona();
		CrearArchivoTXT	archivoTxt  = new CrearArchivoTXT();
		
		
		nuevaPerso.setNombre(txtNombre.getText());
		nuevaPerso.setPrimerApellido(txtApellidoUno.getText());
		nuevaPerso.setSegundoApellido(txtApellidoDos.getText());
		nuevaPerso.setCidudadNatal(txtNatalidad.getText());
		nuevaPerso.setGenero(txtGenero.getText());
		
		// metodo  crea Rachivo del objeto archivoTxt 
		archivoTxt.creaArchivo(nuevaPerso,txtNombArchivo.getText());
		
		
			// cracion del mensaje alert para informacion 
			// de los datos a guardar
		Alert datosGuardados = new Alert(Alert.AlertType.INFORMATION);
		datosGuardados.setTitle("Datos a guardar");
		datosGuardados.setHeaderText("Estos son los datos a guardar");
		datosGuardados.setContentText(nuevaPerso.toString());
		
		datosGuardados.show();
	
		// lanza la eceocion si algo sale mal
		
		}catch (Exception e) {
			Alert errCrearArchivo = new Alert(AlertType.ERROR);
			errCrearArchivo.setHeaderText("No se puede crear el archivo");
			errCrearArchivo.setContentText("Por favor revise los datos e intente nuevamente CtrDatosPersonales");
			errCrearArchivo.show();

		}
	}

	
	public void mostarDatos(ActionEvent event) {
		CargarArchivoTXT carga1 = new CargarArchivoTXT();
			
		try {
			carga1.lecturaAchivo(areaTexto,txtNombArchivo.getText() );
		} catch (FileNotFoundException e) {
			Alert archivoPerdido = new Alert(Alert.AlertType.WARNING);
			archivoPerdido.setHeaderText("Archivo no se encuentra en la ruta");
			archivoPerdido.setContentText("No se encuentra el archivo a cargar , por favor guarde"
					+ "\n la informacion,despues precione el boton mostrar" );
			archivoPerdido.show();
		}
		
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
