package controlador;

import java.util.HashMap;

import modelo.GestionInventario;
import modelo.Producto;

public class Main {

	public static void main(String[] args) {
		HashMap<String, Producto> inventario = new HashMap<>();
		
		GestionInventario.agregarProducto(inventario);
		GestionInventario.eliminarProducto(inventario, "aaa");
		System.out.println("Producto eliminado: " + GestionInventario.eliminarProducto(inventario, "aaaa"));
		GestionInventario.agregarProducto(inventario);
		GestionInventario.mostrarInventario(inventario);
		GestionInventario.mostrarProductosBaratos(inventario, 100);
		if(GestionInventario.actualizarStock(inventario, "aaaa", 10)) {
			System.out.println("Actualizacion de stock registrada");
		} else {
			System.out.println("Error en la actualizacion.");
		}
		
		GestionInventario.mostrarInventario(inventario);
	}

}
