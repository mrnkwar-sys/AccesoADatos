package tema02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio03 {

	public static void main(String[] args) {
		File archivoOrdenado = new File("archivoOrdenado.txt");
		File archivoOrigen = new File("C:\\Users\\mr.nkwar\\Desktop\\Txts\\TxtEjercicio03.txt");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoOrdenado));
				BufferedReader br = new BufferedReader(new FileReader(archivoOrigen))) {
			
			String linea;
			
			while((linea = br.readLine()) != null) {
				//Recorre cada letra del archivo
				for(int i = 0; i < linea.length(); i++) {
					char caracterActual = linea.charAt(i);
					
					//Si la letra es mayúscula y no es la primera del archivo, añadimos un salto de línea antes de escribir
					if (Character.isUpperCase(caracterActual) && i>0) {
						bw.newLine();
					}
					
					//Escribimos el caracter actual
					bw.write(caracterActual);
				}
				bw.newLine();
			}
			
			System.out.println("Archivo procesado y creado correctamente");
			
		} catch (IOException e) {
			System.out.println("Se ha producido un error al intentar crear el archivo");
		}

	}

}
