package model;

public class Product {
	private String id;
	private String name;
	private float price;
	
	
	
	
	public Product() {
		super();
	}




	public Product(String id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String Name) {
		this.name = name;
	}




	public float getPrice() {
		return price;
	}




	public void setPrice(float Price) {
		this.price = price;
	}




	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}




	
	
}
