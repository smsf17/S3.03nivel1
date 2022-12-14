package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.ProductoSerializacionController;
import Controller.Store;
import Model.Arbol;
import Model.Decoracion;
import Model.Flor;
import Model.Producto;
import Model.Configuration.Settings;

public class Floristeria {
	
	public static void main(String[] args) {
		
		/*ArrayList<Producto> products = new ArrayList<Producto>();
		
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
		products.add(decoracion2);*/
		
		//ProductoSerializacionController productoSerializacionController = new ProductoSerializacionController();
		//productoSerializacionController.SerializaProducto();
		//productoSerializacionController.DesSerializaProducto();
		
		Scanner scn = new Scanner(System.in);
		boolean programaActivo = true;
		Store tienda = new Store();

		ProductoSerializacionController ser = new ProductoSerializacionController();
		ArrayList<Producto> products = ser.deserializaVariosproductos(Settings.FITXER_USUARIS);
		System.out.println(products.toString());
		
		do {
			System.out.println("****** Introduzca el la operación ******");
			System.out.println("			1. Comprar producto");
			System.out.println("			2. Vender producto");
			System.out.println("			3. Listado de Stock y valor total");
			System.out.println("			4. Listado de Stock y beneficio esperado");
			System.out.println("			5. Listado Stock");
			System.out.println("			6. Guardar información almacen");
			System.out.println("			0. Salir");
			int opcion = scn.nextInt();
				
			if (opcion == 1) {
				tienda.compraProductos(products);
			}else if (opcion == 2) {
				tienda.ventaProductos(products);
			}else if (opcion == 3) {
				tienda.listadoTotalStock(products);
			}else if (opcion == 4) {
				tienda.valorTotalStock(products);
			}else if (opcion == 5) {
				tienda.imprimirStock(products);
			}else if (opcion == 6) {
				ser.SerializaProducto(products);;
			}else if (opcion == 0) {
				programaActivo = false;
			}else {
				programaActivo = false;
			}
       
		} while (programaActivo);
	

	}

}
