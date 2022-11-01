package Controller;

import java.util.ArrayList;

import Model.Producto;

public interface Operacion {
	
	void compraProductos(ArrayList<Producto> products);
	void ventaProductos(ArrayList<Producto> products);
	void listadoTotalStock(ArrayList<Producto> products);
	void valorTotalStock(ArrayList<Producto> products);
	void imprimirStock(ArrayList<Producto> products);

}
