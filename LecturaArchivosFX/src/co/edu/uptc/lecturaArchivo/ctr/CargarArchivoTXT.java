package co.edu.uptc.lecturaArchivo.ctr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CargarArchivoTXT {
	

	public void lecturaAchivo(TextArea texto, String nombreArchivo ) throws FileNotFoundException {
		try {
			File			ubicacionArchivo;
			FileReader		leeArchivo;
			BufferedReader	buferLectura;
			
			ubicacionArchivo =	new File ("C:\\Users\\Usuario\\Desktop\\"+nombreArchivo+".txt");
			leeArchivo =		new FileReader(ubicacionArchivo);
			buferLectura =		new BufferedReader(leeArchivo);
			
			String lectura;
			while ((lectura = buferLectura.readLine())!= null ) {
				texto.appendText(lectura.toString().toUpperCase());
				texto.appendText("\n");
			}
			
			leeArchivo	.close();
			buferLectura.close();
			
		} catch (Exception e) {
			
			Alert archivoPerdido = new Alert(Alert.AlertType.WARNING);
			archivoPerdido.setHeaderText("Archivo no se encuentra en la ruta");
			archivoPerdido.setContentText("No se encuentra el archivo a cargar , por favor guarde"
					+ "\n la informacion,despues precione el boton mostrar" );
			
			archivoPerdido.show();
		}

	}
}
