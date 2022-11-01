package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoAlmacen {
	
	private String nombreArchivo;

	public ArchivoAlmacen(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	public void crear() throws IOException {
		ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(this.nombreArchivo));
		archivo.close();
		System.out.println("Archivo creado exitosamente");
	}
	
	public void agregar(String string) throws IOException {
		ObjectOutputStream copiaAux = new ObjectOutputStream(new FileOutputStream("copiaAuxiliar.txt"));
		ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(this.nombreArchivo));
		try {
			while(true) {
				String producto = (String) archivo.readObject();
				copiaAux.writeObject(producto);
			}			
		} catch (Exception e) {
			/*Scanner scn = new Scanner(System.in);
			String nuevoProducto =scn.nextLine();*/
			copiaAux.writeObject(string);
			
			copiaAux.close();
			archivo.close();
			
			File fArchivo = new File(this.nombreArchivo);
			File fCopiaArchivo = new File("CopiaAuxiliar.txt");
			
			fArchivo.delete();
			fCopiaArchivo.renameTo(fArchivo);
			
			System.out.println("Archivo agregando exitosamente");
		}
	
	}
	
	public void listar(String string) throws IOException {
		ObjectOutputStream copiaAux = new ObjectOutputStream(new FileOutputStream("copiaAuxiliar.txt"));
		ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(this.nombreArchivo));
		try {
			System.out.println("Stock en almacen:");
			while(true) {
				String producto = (String) archivo.readObject();
				System.out.println(producto);
				copiaAux.writeObject(producto);
			}			
		} catch (Exception e) {
			
			copiaAux.close();
			archivo.close();
			
			File fArchivo = new File(this.nombreArchivo);
			File fCopiaArchivo = new File("CopiaAuxiliar.txt");
			
			fArchivo.delete();
			fCopiaArchivo.renameTo(fArchivo); 
		}
	
	}
	
	/*public void serializaVariosProductos(ArrayList<Producto> products) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream("C:\\Users\\Pau\\Downloads\\ArchivoAlmacen.txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(products);
			System.out.println("Objeto serializado correctamente en el fichero ");

		} catch (IOException e) {
			System.err.println("Error Serialización: " + e.getMessage());
		} finally {
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					System.err.println("Error cierre objectOutputStream: " + e.getMessage());
				}
			}
		}

	}*/

}
