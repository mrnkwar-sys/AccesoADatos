package pruebas;
import java.io.*;

public class Prueba01 {

	public static void main(String[] args) {
		//String dir = "."; //Directorio actual
		String dir ="C:\\Users\\";
		
		//Instancia de la clase file vinculada a la ruta especificada
		File f = new File(dir);
		
		//El método list devuelve un String[] que contiene los nombres de todas las carpetas y archivos dentro del directorio
		String[] archivos = f.list();
		
		//Imprime por consola el total de elementos encontrados
		//%d para la cantidad y %n para el salto de línea
		System.out.printf("Ficheros en el directorio actual: %d %n", archivos.length);
		
		for (int i = 0; i < archivos.length; i++) {
			//Creando un objeto File para el elemento combinando la carpeta padre (f) con el nombre del elemento (archivos[i])
			File f2 = new File(f, archivos[i]);
			
			//Imprime el nombre del elemento (%s) y si es un archivo o un directorio
			System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", archivos[i], f2.isFile(), f2.isDirectory());
		}

	}

}
