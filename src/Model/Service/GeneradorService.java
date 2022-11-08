package Model.Service;

import java.util.ArrayList;

import Model.Arbol;
import Model.Decoracion;
import Model.Flor;
import Model.Producto;


public class GeneradorService {
	
	public Producto getProducto() {
	
		Producto product = null;
		product = new Arbol(1, "Pino", 12, 9, 50, 100);
		return product;
	}
	
}
