package clases;

public class Products {
	 int ID ;
	String NameProduct;
	String Category;
	double Price ;
	String statusProduct ;
	public Products() {
		super();
	}
	public Products(int iD, String nameProduct, String category, double price, String statusProduct) {
		super();
		ID = iD;
		NameProduct = nameProduct;
		Category = category;
		Price = price;
		this.statusProduct = statusProduct;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNameProduct() {
		return NameProduct;
	}
	public void setNameProduct(String nameProduct) {
		NameProduct = nameProduct;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getStatusProduct() {
		return statusProduct;
	}
	public void setStatusProduct(String statusProduct) {
		this.statusProduct = statusProduct;
	}
	
	
}
