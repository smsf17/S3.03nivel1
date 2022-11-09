package Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Model.Producto;
import Model.Configuration.Settings;
import Model.Service.GeneradorService;
import Model.Service.ProductoSerializacionBinariaService;
import View.UtilitatsSortidaView;

public class ProductoSerializacionController {
	
	public void SerializaProducto(ArrayList<Producto> products)
	{
		/*GeneradorService generadorService = new GeneradorService();
		Producto products = generadorService.getProducto();*/
		
		ProductoSerializacionBinariaService service = new ProductoSerializacionBinariaService();
		try {
			service.serializa(products);
			UtilitatsSortidaView utilitatsSortidaView = new UtilitatsSortidaView ();
			utilitatsSortidaView.show("Serialización realizada correctamente" , false); 
		} catch (IOException e) {
			UtilitatsSortidaView utilitatsSortidaView = new UtilitatsSortidaView ();
			utilitatsSortidaView.show(e.getMessage() , true);
		}
	}
	
	/*public void DesSerializaProducto()
	{
		ProductoSerializacionBinariaService service = new ProductoSerializacionBinariaService();
		
			try {
				Producto products = service.desSerializa();
				UtilitatsSortidaView utilitatsSortidaView = new UtilitatsSortidaView ();
				utilitatsSortidaView.show(products.toString() , false); 
			} catch (ClassNotFoundException e) {
				UtilitatsSortidaView utilitatsSortidaView = new UtilitatsSortidaView ();
				utilitatsSortidaView.show(e.getMessage() , true); 
				
			} catch (IOException e) {

				UtilitatsSortidaView utilitatsSortidaView = new UtilitatsSortidaView ();
				utilitatsSortidaView.show(e.getMessage() , true); 
				
			}
		
	}*/
	@SuppressWarnings("unchecked")
	public ArrayList<Producto> deserializaVariosproductos(String nombreFichero) {
		ArrayList<Producto> products = null;

		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;

		try {
			fileInputStream = new FileInputStream(nombreFichero);
			objectInputStream = new ObjectInputStream(fileInputStream);
			products = (ArrayList<Producto>) objectInputStream.readObject();
			System.out.println("Alumnos deserializado correctamente.");
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error deserialización: " + e.getMessage());
		} finally {
			if (objectInputStream != null) {
				try {
					objectInputStream.close();
				} catch (IOException e) {
					System.err.println("Error cierre objectInputStream: " + e.getMessage());
				}
			}
		}

		return products;
	}
	
}
