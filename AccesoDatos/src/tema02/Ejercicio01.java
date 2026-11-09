package tema02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Obtenemos la ruta de mi carpeta personal (C:\Users\[nombre_usuario])
        String userHome = System.getProperty("user.home");
        
        // Ruta del archivo .txt que contiene la estructura de carpetas
        File archivoTXT = new File("C:\\Users\\mr.nkwar\\Desktop\\TxtEjercicio01.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(archivoTXT))) {
            //Almacena temporalmente cada ruta leída del archivo
        	String linea;
            
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                
                // Si la línea no está vacía, creamos el directorio
                if (!linea.isEmpty()) {
                	//Crea un objeto File combinando la ruta personal con la subruta del archivo
                    File nuevaCarpeta = new File(userHome, linea);
                    
                    if (nuevaCarpeta.mkdirs()) {
                        System.out.println("Creada correctamente: " + nuevaCarpeta.getAbsolutePath());
                    } else if (nuevaCarpeta.exists()) {
                        System.out.println("Ya existe: " + nuevaCarpeta.getAbsolutePath());
                    } else {
                        System.err.println("No se pudo crear: " + nuevaCarpeta.getAbsolutePath());
                    }
                }
            }
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
	}

}
