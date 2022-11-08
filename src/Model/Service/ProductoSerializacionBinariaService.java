package Model.Service;

import java.io.IOException;

import Model.Producto;
import Model.Configuration.Settings;
import Model.Repository.ProductoSerializacionBinariaRepository;

public class ProductoSerializacionBinariaService {
	
	public void serializa (Producto products) throws IOException
	{
		ProductoSerializacionBinariaRepository rep = new ProductoSerializacionBinariaRepository();
		rep.serializacionVariosProducto(products, Settings.FITXER_USUARIS);
	}
	
	public Producto desSerializa () throws IOException, ClassNotFoundException
	{
		ProductoSerializacionBinariaRepository rep = new ProductoSerializacionBinariaRepository();
		return rep.desSerializacionVariosProducto(Settings.FITXER_USUARIS);
	}

}
