package Model;

public class Decoracion extends Producto{

	public String material;

	public Decoracion(int id, String nameProduct, double priceSale, double priceBuy, int cantidad, String material) {
		super(id, nameProduct, priceSale, priceBuy, cantidad);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Decoración: " + producto() +", Material (Plastico/Madera):" + material ;
	}
	
}
