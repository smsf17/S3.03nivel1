package Model;

import java.io.Serializable;

public abstract class Producto implements Serializable{

	private static int idProducto = 1;
	
	private int id;
	private String nameProduct;
	private double priceSale;
	private double priceBuy;
	private int cantidad;
		
	public Producto(int id, String nameProduct, double priceSale, double priceBuy, int cantidad) {
		super();
		this.id = idProducto++;
		this.nameProduct = nameProduct;
		this.priceSale = priceSale;
		this.priceBuy = priceBuy;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
			this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public double getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(double priceSale) {
		this.priceSale = priceSale;
	}

	public double getPriceBuy() {
		return priceBuy;
	}

	public void setPriceBuy(double priceBuy) {
		this.priceBuy = priceBuy;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
		
	public void setCantidadComprada(int cantidadComprada) {
		this.cantidad += cantidadComprada;
	}
		
	public void setCantidadVendida(int cantidadVendida) {
		this.cantidad -= cantidadVendida;
	}

	public String producto() {
		return "id: " + id + ", Nombre: " + nameProduct + ", Precio Venta: " + priceSale + 
				", Precio Compra: "	+ priceBuy + ", Cantidad Disponible: " + cantidad ;
	}
				
}
