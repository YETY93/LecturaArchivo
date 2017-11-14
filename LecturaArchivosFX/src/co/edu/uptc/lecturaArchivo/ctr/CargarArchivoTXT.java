package co.edu.uptc.lecturaArchivo.ctr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class CargarArchivoTXT {
	

	public String lecturaAchivo(String nombreArchivo, String strDats) throws FileNotFoundException {
		try {
			File			ubicacionArchivo;
			FileReader		leeArchivo;
			BufferedReader	buferLectura;
			
			ubicacionArchivo =	new File ("C:\\Users\\Usuario\\Desktop\\"+nombreArchivo+".txt");
			leeArchivo =		new FileReader(ubicacionArchivo);
			buferLectura =		new BufferedReader(leeArchivo);
			
			
			while ((strDats = buferLectura.readLine())!= null ) {
				System.out.println(strDats);
			
			Alert datosEncontrados = new Alert(Alert.AlertType.INFORMATION);
			datosEncontrados.setHeaderText(" Se ha encuentrado lo siguiente");
			datosEncontrados.setContentText(strDats );
			datosEncontrados.show();
			
			
			leeArchivo	.close();
			buferLectura.close();
			
		} 
		}
		catch (Exception e) {
			
			Alert archivoPerdido = new Alert(Alert.AlertType.WARNING);
			archivoPerdido.setHeaderText("Archivo no se encuentra en la ruta");
			archivoPerdido.setContentText("No se encuentra el archivo a cargar , por favor guarde"
					+ "\n la informacion,despues precione el boton mostrar" );
			
			archivoPerdido.show();
		}
		return strDats;

	}
}
