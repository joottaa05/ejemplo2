package modelo;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class GestionInventario {

	public static void agregarProducto(Map<String, Producto> inventario) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el codigo del producto(String): ");
		String codigo = sc.next();
		System.out.println("Introduce el nombre del producto(String): ");
		String nombre = sc.next();
		System.out.println("Introduce el precio del producto(double): ");
		double precio = sc.nextDouble();
		System.out.println("Introduce la cantidad de productos(int): ");
		int cantidad = sc.nextInt();

		Producto p = new Producto(codigo, nombre, precio, cantidad);
		inventario.put(codigo, p);

	}

	public static Producto eliminarProducto(Map<String, Producto> inventario, String codigo) {
		if (inventario.containsKey(codigo)) {
			Producto p1 = inventario.get(codigo);
			inventario.remove(codigo);
			
			return p1;
		} else {
			return null;
		}
	}

	public static void mostrarInventario(Map<String, Producto> inventario) {
		ArrayList<String> listaCodigos = new ArrayList<>(inventario.keySet());

		for (String s : listaCodigos) {
			System.out.println("Codigo: " + s + ", Producto: " + inventario.get(s));
		}
	}

	public static void mostrarProductosBaratos(Map<String, Producto> inventario, double maxPrecio) {
		ArrayList<String> listaCodigos = new ArrayList<>(inventario.keySet());
		for (String s : listaCodigos) {
			if (inventario.get(s).getPrecio() <= maxPrecio) {
				System.out.println(inventario.get(s));
			}
		}
	}

	public static boolean actualizarStock(Map<String, Producto> inventario, String codigo, int cantidad) {
		if (inventario.containsKey(codigo)) {
			if (inventario.get(codigo).getStock() >= 0) {
				inventario.get(codigo).setStock(inventario.get(codigo).getStock() + cantidad);
			} else if (inventario.get(codigo).getStock() < 0) {
				inventario.get(codigo).setStock(inventario.get(codigo).getStock() - cantidad);
			}
			return true;
		} else {
			return false;
		}
	}
}
