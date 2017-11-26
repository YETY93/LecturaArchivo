package co.edu.uptc.lecturaArchivo.ctr;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.lecturaArchivo.main.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CrearArchivoTXT {
	
	public void creaArchivo(Persona DtsPersona, String nbreArchivo) throws IOException {
		
			File				rutaArchivo;
			FileWriter			fWAchivo;
			BufferedWriter  	buferEscritura;
			PrintWriter			escribeArchivo;
			try {
			
			rutaArchivo		= new File("C:\\Users\\Usuario\\Desktop\\"+nbreArchivo+".txt");
			fWAchivo   		= new FileWriter(rutaArchivo);
			buferEscritura  = new BufferedWriter(fWAchivo);
			escribeArchivo	= new PrintWriter(buferEscritura);
			
		
			// Crea una ObservableList para alamcenar los datos de la persona
			
			List <String> listaDatosPerso = new ArrayList<String>();
			ObservableList<String> obListDtsPersona = FXCollections.observableList(listaDatosPerso);
		
				if (obListDtsPersona.isEmpty()) {
					obListDtsPersona.add(DtsPersona.getNombre());
					obListDtsPersona.add("|" + DtsPersona.getPrimerApellido());
					obListDtsPersona.add("|" + DtsPersona.getSegundoApellido());
					obListDtsPersona.add("|" + DtsPersona.getCidudadNatal());
					obListDtsPersona.add("|" + DtsPersona.getGenero());
					obListDtsPersona.add("\n");
					
					// Escribe los datos en el archivo de texto, tomados de la ObservableList
					escribeArchivo.write(obListDtsPersona.get(0).toString().toUpperCase());
					escribeArchivo.append(obListDtsPersona.get(1).toString().toUpperCase());
					escribeArchivo.append(obListDtsPersona.get(2).toString().toUpperCase());
					escribeArchivo.append(obListDtsPersona.get(3).toString().toUpperCase());
					escribeArchivo.append(obListDtsPersona.get(4).toString().toUpperCase());
					escribeArchivo.append("\n");
				}else {
					// Escribe los datos en el archivo de texto, tomados de la ObservableList
					
					escribeArchivo.write (obListDtsPersona.get(0).toString().toUpperCase());
					escribeArchivo.append(obListDtsPersona.get(1).toString().toUpperCase());
					escribeArchivo.append(obListDtsPersona.get(2).toString().toUpperCase());
					escribeArchivo.append(obListDtsPersona.get(3).toString().toUpperCase());
					escribeArchivo.append(obListDtsPersona.get(4).toString().toUpperCase());
					escribeArchivo.append("\n");
				
				}

	
			
			buferEscritura.close();
			escribeArchivo.close();
			
			
		} catch (Exception e) {
			
			Alert erroCrearArchivo = new Alert(AlertType.ERROR);
			erroCrearArchivo.setHeaderText("No se puede crear el archivo");
			erroCrearArchivo.setContentText("Por favor revise los datos e intente nuevamente."
			+ "\n Detalle del error " + e);
			erroCrearArchivo.show();
			

			
		}

		
		
		
		
		
	}

}
