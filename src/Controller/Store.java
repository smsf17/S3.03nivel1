package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Arbol;
import Model.Decoracion;
import Model.Flor;
import Model.Producto;
import Model.Configuration.Settings;
import Model.Repository.ProductoSerializacionBinariaRepository;

public class Store implements Operacion {
	
	//List<Producto> products = new ArrayList<Producto>();

	@Override
	public void compraProductos(ArrayList<Producto> products) {
		Scanner scn = new Scanner(System.in);
		
		//ProductoSerializacionController ser = new ProductoSerializacionController();
		
		System.out.println("Introduzca ID del producto: ");
		int idSolicitado = scn.nextInt();
		scn.nextLine();
		
        int opcion = 0;
        Producto solicitado = null;
        
        for (Producto prod: products)
        
        if (prod.getId() == idSolicitado)
			solicitado = prod;
        	if (solicitado != null){
        	System.out.println("Cuantos nuevos productos a comprado: ");
        	int nuevacantidad = scn.nextInt();
        	solicitado.setCantidadComprada(nuevacantidad);
        	System.out.println("Stock producto modificado: " + solicitado.toString());
        }else {
        	int nuevoId = idSolicitado;
        	System.out.println("Id producto: " + nuevoId);
            scn.nextLine();
            System.out.println("Nombre del producto: ");
            String nombre = scn.nextLine();
            System.out.println("Precio de venta: ");
            double pVenta = scn.nextDouble();
            scn.nextLine();
            System.out.println("Precio de compra: ");
            double pCompra = scn.nextDouble();
            scn.nextLine();
            System.out.println("Cuantos productos se han comprado: ");
        	int ncantidad = scn.nextInt();
        	scn.nextLine();
            
	            System.out.println("****** Introduzca el tipo de producto ******");
	            System.out.println("			1. Flor");
	            System.out.println("			2. Arbol");
	            System.out.println("			3. Decoración");
	            opcion = scn.nextInt();
	            scn.nextLine();
	       

           switch(opcion){
           		case 1: System.out.println("Introduzca el color de la flor: ");
           				String nColor = scn.nextLine();
           				Producto flor = new Flor(nuevoId, nombre, pVenta, pCompra, ncantidad, nColor);
           				products.add(flor);
           				System.out.println("Nuevo producto registrado: " + flor.toString());
                        break;
                case 2: System.out.println("Introduzca el tamaño del arbol: ");
   						double nTamano = scn.nextDouble();
   						Producto arbol = new Arbol(nuevoId, nombre, pVenta, pCompra, ncantidad, nTamano);
   						products.add(arbol);
   						System.out.println("Nuevo producto registrado: " + arbol.toString());
   						break;
                case 3: System.out.println("Introduzca el material (Plastic / Fusta): ");
                		String nmaterial = scn.nextLine();
   						Producto decoracion = new Decoracion(nuevoId, nombre, pVenta, pCompra, ncantidad, nmaterial);
   						products.add(decoracion);
   						System.out.println("Nuevo producto registrado: " + decoracion.toString());
						break;
           }
        }

	}

	@Override
	public void ventaProductos(ArrayList<Producto> products) {
		Scanner scn = new Scanner(System.in);
		Producto solicitada = null;
		
		System.out.println ("Id de producto solicitado: ");
		int idSolicitado = scn.nextInt();
		System.out.println ("Cantidad producto solicitado: ");
		int cantidadSolicitada = scn.nextInt();
		
		for (Producto prod:products) 
			if (prod.getId()== idSolicitado)
				solicitada = prod;
		if (solicitada == null)
			System.out.println("Producto no encontrado: " + idSolicitado);
		else {
			if (solicitada.getCantidad()>= cantidadSolicitada) {
				System.out.println("id producto: " + solicitada.getId() + " " + solicitada.getNameProduct() + " precio unitario: "
					+ solicitada.getPriceSale() + "€  Cantidad compra: " + cantidadSolicitada + " Total compra " + solicitada.getPriceSale()*cantidadSolicitada + "€");
					solicitada.setCantidadVendida(cantidadSolicitada);
			}
			else if (solicitada.getCantidad()== 0) {
				System.out.println("No hay disponibilidad del producto.");
				}
			else {
				double importeVenta = solicitada.getPriceSale() * solicitada.getCantidad();
				System.out.println("No hay existencias suficientes para la cantidad solicitada");
				System.out.println("Disponemos de:" + solicitada.getCantidad() + " unidades y seria un total de: " + importeVenta);
					solicitada.setCantidadVendida(solicitada.getCantidad());
				}
				
		}


	}

	@Override
	public void listadoTotalStock(ArrayList<Producto> products) {
		double totalStock=0;
		for(Producto prod:products) {
			System.out.println(prod.producto());
			totalStock=totalStock+(prod.getCantidad()*prod.getPriceBuy());
		}
		System.out.println("El total invertido en Stock es de:"+ totalStock + "€");

	}

	@Override
	public void valorTotalStock(ArrayList<Producto> products) {
		double totalBeneficio=0;
		for(Producto prod:products) {
			double Beneficio= prod.getPriceSale()+prod.getCantidad()-prod.getCantidad()*prod.getPriceBuy();
			System.out.println(prod.producto() + "Beneficio esperado: "+Beneficio);
			totalBeneficio=totalBeneficio+Beneficio;
		}
		System.out.println("El total invertido en Stock es de:"+ totalBeneficio + "€");

	}

	@Override
	public void imprimirStock(ArrayList<Producto> products) {
		
		for(Producto prod:products) {
			System.out.println(prod.producto());
		}

	}

}
