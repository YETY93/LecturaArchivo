package co.edu.uptc.lecturaArchivo.ctr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CargarArchivoTXT {
	

	public  String leeArchivoTXT (TextField nombreArchivo) throws FileNotFoundException {
		
			File			ubicacionArchivo;
			FileReader		leeArchivo;
			BufferedReader	buferLectura;
			String          strDats = null;
			
			try {
				
			
				ubicacionArchivo =	new File ("C:\\Users\\Usuario\\Desktop\\"+nombreArchivo.getText()+".txt");
				leeArchivo       =	new FileReader(ubicacionArchivo);
				buferLectura     =	new BufferedReader(leeArchivo);
				
				
				while ((strDats = buferLectura.readLine())!= null ) {
					System.out.println(strDats);

				Alert datosEncontrados = new Alert(Alert.AlertType.INFORMATION);
				datosEncontrados.setHeaderText(" Se ha encuentrado lo siguiente");
				datosEncontrados.setContentText(strDats );
				datosEncontrados.show();
				
				} 
			buferLectura.close();
			leeArchivo.close();
				
			System.out.println(strDats);

		}catch (Exception e) {
			
			Alert archivoPerdido = new Alert(Alert.AlertType.WARNING);
			archivoPerdido.setTitle("Error carga datos" );
			archivoPerdido.setHeaderText("Archivo no se encuentra en la ruta");
			archivoPerdido.setContentText("No se encuentra el archivo a cargar , por favor guarde"
					+ "\n la informacion,despues precione el boton mostrar"
					+ "\n " + e);
			
			archivoPerdido.show();
		}
			
			return strDats;
		
		
		
		
	}




}
