package co.edu.uptc.lecturaArchivo.ctr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import co.edu.uptc.lecturaArchivo.main.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;



public class CtrDatosPersonales implements Initializable {
	
	
		@FXML
		private TextField			txtNombArchivo;
		@FXML
		private TextField 			txtNombre;
		@FXML
		private TextField 			txtApellidoUno;
		@FXML
		private TextField			txtApellidoDos;
		@FXML
		private TextField			txtNatalidad;
		@FXML
		private TextField			txtGenero;
		@FXML
		private Button				guardar;
		@FXML
		private Button 				capturaInformacion;
		@FXML
		private TextArea 			areaTexto;
		@FXML
		private TableView <Persona> tablaDatosPerso;
		@FXML
		private TableColumn<Persona, String> colNombre;
		@FXML
		private TableColumn<Persona, String> colApellido1;
		@FXML
		private TableColumn<Persona, String> colApellido2;
		@FXML
		private TableColumn<Persona, String> colCiudad;
		@FXML
		private TableColumn<Persona, String> colGenero;
	
		
		
		
	//////////// METODO QUE CREA LOS ARCHIVOS TXT 
	
	public void guardarDatos(ActionEvent event) {
		Persona 		nuevaPerso;
		CrearArchivoTXT	archivoTxt;
		try {
					
			// creacion de obejo persona y la escritura de archivo
			
		nuevaPerso 	= new Persona(txtNombre.getText(), txtApellidoUno.getText(),
				txtApellidoDos.getText(), txtNatalidad.getText(),
				txtGenero.getText());
		
		archivoTxt  = new CrearArchivoTXT();

		
		// metodo  crea Rachivo del objeto archivoTxt 
		archivoTxt.creaArchivo(nuevaPerso,txtNombArchivo.getText());
		
		if (txtNombArchivo.getText().isEmpty()) {
			Alert faltaInformacion = new Alert(Alert.AlertType.WARNING);
			faltaInformacion.setTitle("Campo vacio");
			faltaInformacion.setHeaderText("No hay datos a guardar");
			faltaInformacion.setContentText("EL campo Guardar como esta vacio");
			
			faltaInformacion.show();
			
		}else {
		
			// cracion del mensaje alert para informacion 
			// de los datos a guardar
		Alert datosGuardados = new Alert(Alert.AlertType.INFORMATION);
		datosGuardados.setTitle("Datos a guardar");
		datosGuardados.setHeaderText("Estos son los datos a guardar");
		datosGuardados.setContentText(
			  "Nombre                 : "+ nuevaPerso.getNombre()
			+ "\n" + "Primer Apellido     : "+ nuevaPerso.getPrimerApellido()
			+ "\n" + "Segundo Apellido : "+ nuevaPerso.getSegundoApellido()
			+ "\n" + "Ciudad Natal	      : "+ nuevaPerso.getCidudadNatal()
			+ "\n" + "Genero                  : "+ nuevaPerso.getGenero());
		
		datosGuardados.show();
		}
	
		// lanza la eceocion si algo sale mal
		
		}catch (Exception e) {
			Alert errCrearArchivo = new Alert(AlertType.ERROR);
			errCrearArchivo.setHeaderText("No se puede crear el archivo");
			errCrearArchivo.setContentText("Por favor revise los datos e intente nuevamente CtrDatosPersonales");
			errCrearArchivo.show();

		}
	}

	
	
	
	/////// ACCIÓN QUE LEE LOS ARCHIVOS TXT 
	
	public void leeDatosArchivo(ActionEvent event) {
		
		File				ubicacionArchivo;
		FileReader			leeArchivo;
		BufferedReader		buferLectura;
		List<String>        arrayDatosDiv;
		String          	strDats;
		String				separador;
		

		try {
			
		
			ubicacionArchivo =	new File ("C:\\Users\\Usuario\\Desktop\\"+
			txtNombArchivo.getText()+".txt");
			
			leeArchivo       =	new FileReader(ubicacionArchivo);
			buferLectura     =	new BufferedReader(leeArchivo);
			arrayDatosDiv	 =  new ArrayList<String>();
			separador		 =  Pattern.quote("|");
		
		
			
			
			while ((strDats = buferLectura.readLine())!= null ) {
				String[] divisionDatos = strDats.split(separador);
				arrayDatosDiv.add(divisionDatos[0].toUpperCase());
				arrayDatosDiv.add(divisionDatos[1].toUpperCase());
				arrayDatosDiv.add(divisionDatos[2].toUpperCase());
				arrayDatosDiv.add(divisionDatos[3].toUpperCase());
				arrayDatosDiv.add(divisionDatos[4].toUpperCase());
				

				
				//System.out.println(strDats);

			Alert datosEncontrados = new Alert(Alert.AlertType.INFORMATION);
			datosEncontrados.setHeaderText(" Se ha encuentrado lo siguiente");
			datosEncontrados.setContentText(strDats );
			datosEncontrados.show();
			
			
			
			} 
		    final ObservableList<Persona> datosOptDiv = FXCollections.observableArrayList(
		            new Persona(arrayDatosDiv.get(0), arrayDatosDiv.get(1),  
		            		arrayDatosDiv.get(2), arrayDatosDiv.get(3), 
		            		arrayDatosDiv.get(4))
		           

		        );
			colNombre.setCellValueFactory(   new PropertyValueFactory <Persona, String>("nombre"));
			colApellido1.setCellValueFactory(new PropertyValueFactory <Persona, String>("primerApellido"));
			colApellido2.setCellValueFactory(new PropertyValueFactory <Persona, String>("segundoApellido"));
			colCiudad.setCellValueFactory(   new PropertyValueFactory <Persona, String>("cidudadNatal"));
			colGenero.setCellValueFactory(   new PropertyValueFactory <Persona, String>("genero"));
			
			tablaDatosPerso.setItems(datosOptDiv);

			
			System.out.println();

		buferLectura.close();
		leeArchivo.close();
			
		

	}catch (Exception e) {
		
		Alert archivoPerdido = new Alert(Alert.AlertType.WARNING);
		archivoPerdido.setTitle("Error carga datos" );
		archivoPerdido.setHeaderText("Archivo no se encuentra en la ruta");
		archivoPerdido.setContentText("No se encuentra el archivo a cargar , por favor guarde"
				+ "\n la informacion,despues precione el boton mostrar"
				+ "\n " + e);
		
		archivoPerdido.show();
	}
		
			
		
	}
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	
	}
}
