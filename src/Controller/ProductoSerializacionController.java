package Controller;

import java.io.IOException;

import Model.Producto;
import Model.Service.GeneradorService;
import Model.Service.ProductoSerializacionBinariaService;
import View.UtilitatsSortidaView;

public class ProductoSerializacionController {
	
	public void SerializaProducto()
	{
		GeneradorService generadorService = new GeneradorService();
		Producto products = generadorService.getProducto();
		
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
	
	public void DesSerializaProducto()
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
		
	}
	
}
