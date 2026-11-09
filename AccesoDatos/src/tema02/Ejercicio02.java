package tema02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio02 {
	
	private static final String MI_NOMBRE = "María Raquel Nkwar Ipa";

	public static void main(String[] args) {
		// Obtenemos la carpeta raíz de la estructura (C:\Users\[usuario]\AD)
        String userHome = System.getProperty("user.home");
        File directorioRaiz = new File(userHome, "AD");

        if (directorioRaiz.exists() && directorioRaiz.isDirectory()) {
            recorrerYCrearHTML(directorioRaiz);
            System.out.println("Proceso finalizado con éxito.");
        } else {
            System.err.println("La carpeta raíz no existe: " + directorioRaiz.getAbsolutePath());
        }
	}
	
	/**
     * Método para recorrer carpetas y crear el archivo HTML en cada una
     */
    private static void recorrerYCrearHTML(File carpetaActual) {
        // Creamos el archivo HTML en la carpeta actual
        crearArchivoHTML(carpetaActual);

        // Obtenemos los elementos hijos de la carpeta actual
        File[] contenido = carpetaActual.listFiles();

        if (contenido != null) {
            for (File elemento : contenido) {
                // Si el elemento es un directorio, seguimos recorriendo
                if (elemento.isDirectory()) {
                    recorrerYCrearHTML(elemento);
                }
            }
        }
    }
    
    /**
     * Escribe el contenido HTML en cada archivo
     */
    private static void crearArchivoHTML(File carpeta) {
        String nombreCarpeta = carpeta.getName();
        File archivoHTML = new File(carpeta, nombreCarpeta + ".html");

        String contenidoHTML = "<html>\n"
                + "  <head>\n"
                + "    <title>" + nombreCarpeta + "</title>\n"
                + "  </head>\n"
                + "  <body>\n"
                + "    <h1>" + nombreCarpeta + "</h1>\n"
                + "    <h3>Autor: " + MI_NOMBRE + "</h3>\n"
                + "  </body>\n"
                + "</html>";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoHTML))) {
            bw.write(contenidoHTML);
            System.out.println("Archivo creado: " + archivoHTML.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al crear HTML en " + carpeta.getAbsolutePath() + ": " + e.getMessage());
        }
    }

}
