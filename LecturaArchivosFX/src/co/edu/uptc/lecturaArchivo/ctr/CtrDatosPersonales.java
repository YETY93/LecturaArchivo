package co.edu.uptc.lecturaArchivo.ctr;


import java.net.URL; 
import java.util.ResourceBundle;

import co.edu.uptc.lecturaArchivo.main.DatosUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
		
	
	public void GuardarDatos(ActionEvent event) {
		DatosUsuario nuevo1 = new DatosUsuario();
		nuevo1.setNombre(txtNombre.getText());
		nuevo1.setPrimerApellido(txtApellidoUno.getText());
		nuevo1.setSegundoApellido(txtApellidoDos.getText());
		nuevo1.setCidudadNatal(txtNatalidad.getText());
		nuevo1.setGenero(txtGenero.getText());
		System.out.println(nuevo1);
	}
		
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
