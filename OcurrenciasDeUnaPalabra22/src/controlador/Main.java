package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader in = null;
		System.out.println("hola");
		try {
			System.out.println("Introduzca una palabra para ver cuantas veces aparece el el fichero: ");
			String palabra = sc.nextLine();
			String ruta = "src/fichero.txt";
			in = new BufferedReader(new FileReader(ruta)); 
			
			int cantidadRepeticiones = 0;
			String linea;
			String textoFichero = "";
			while((linea = in.readLine()) != null) {
				textoFichero += linea + " ";
			}
			
			String[] palabras = textoFichero.split(" ");
			for(String s: palabras) {
				if(palabra.equals(s)) {
					cantidadRepeticiones++;
				}
			}
			for(int i = 0;i<ruta.length()-palabra.length();i++) {
				if(ruta.substring(i, i + palabra.length()).equals(palabra)) {
					cantidadRepeticiones++;
				}
			}
			System.out.println(textoFichero);
			System.out.println("La palabra '" + palabra + "' aparece " + cantidadRepeticiones + " veces.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
