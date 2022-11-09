package Model.Repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Model.Producto;

public class ProductoSerializacionBinariaRepository {
	
	public void serializacionUnProducto(Producto products, String nombreFichero) throws IOException
	{
		FileOutputStream fileOutputStream = new FileOutputStream(nombreFichero);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream );
		
		objectOutputStream.writeObject(products);
		objectOutputStream.close();
	}
	
	public void serializacionVariosProducto(ArrayList<Producto> products, String nombreFichero) throws IOException
	{
		FileOutputStream fileOutputStream = new FileOutputStream(nombreFichero);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream );
		
		objectOutputStream.writeObject(products);
		objectOutputStream.close();
	}
	
	public Producto desSerializacionVariosProducto(String nombreFichero) throws IOException, ClassNotFoundException
	{
		Producto resultado = null;
		FileInputStream fileInputStream = new FileInputStream(nombreFichero);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream );
		
		resultado = (Producto) objectInputStream.readObject();
		
		return resultado;
	}

}
