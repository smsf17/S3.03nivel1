package Model;

public class Arbol extends Producto{

	public double height;

	public Arbol(int id, String nameProduct, double priceSale, double priceBuy, int cantidad, double height) {
		super(id, nameProduct, priceSale, priceBuy, cantidad);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Arbol: " + producto() +", Altura:" + height ;
	}
	
}
