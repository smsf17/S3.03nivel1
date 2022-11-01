package View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.Store;
import Model.Arbol;
import Model.ArchivoAlmacen;
import Model.Decoracion;
import Model.Flor;
import Model.Producto;

public class Floristeria {
	
	public static void main(String[] args) throws IOException {
		ArrayList<Producto> products = new ArrayList<Producto>();
		
		Arbol arbol1 = new Arbol(1, "Pino", 12, 9, 50, 100);
		Arbol arbol2 = new Arbol(2, "Cedro", 25, 21, 40, 150);
		Flor flor1 = new Flor(3, "Margarita", 3, 1.50, 100, "blanca");
		Flor flor2 = new Flor(4, "Girasol", 5, 3, 150, "Amarilla");
		Decoracion decoracion1 = new Decoracion(5, "Florero", 3, 1.50, 100, "Plastico");
		Decoracion decoracion2 = new Decoracion(6, "Banco", 5, 3, 150, "Madera");
		products.add(arbol1);
		products.add(arbol2);
		products.add(flor1);
		products.add(flor2);
		products.add(decoracion1);
		products.add(decoracion2);
		
		ArchivoAlmacen ArA= new ArchivoAlmacen("C:\\Users\\Pau\\Downloads\\ArchivoAlmacen.txt");
		/*ArA.crear();
		ArA.agregar(products.toString());
		ArA.listar(products.toString());*/
		
		Scanner scn = new Scanner(System.in);
		boolean programaActivo = true;
		Store tienda = new Store();
		
		do {
			System.out.println("****** Introduzca el la operación ******");
			System.out.println("			1. Comprar producto");
			System.out.println("			2. Vender producto");
			System.out.println("			3. Listado de Stock y valor total");
			System.out.println("			4. Listado de Stock y beneficio esperado");
			System.out.println("			5. Listado Stock");
			System.out.println("			0. Salir");
			int opcion = scn.nextInt();
				
			if (opcion == 1) {
				tienda.compraProductos(products);
				ArA.agregar(products.toString());
			}else if (opcion == 2) {
				tienda.ventaProductos(products);
				ArA.agregar(products.toString());
			}else if (opcion == 3) {
				tienda.listadoTotalStock(products);
			}else if (opcion == 4) {
				tienda.valorTotalStock(products);
			}else if (opcion == 5) {
				tienda.imprimirStock(products);
				ArA.listar(products.toString());
			}else if (opcion == 0) {
				programaActivo = false;
			}else {
				programaActivo = false;
			}
       
		} while (programaActivo);
	

	}

}
