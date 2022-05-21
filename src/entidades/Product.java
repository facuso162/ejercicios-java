package entidades;

import java.sql.Date;

public class Product {
	private int id;
	private String name;
	private String description;
	private double price;
	private int stock;
	private boolean shippingIncluded;
	//ejercicio 6b
	private Date disabledOn;
	
	public Product() {
		
	}
	
	public Product(int id) {
		this.id = id;
	}

	public Product(String name, String description, double price, int stock, boolean shippingIncluded) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.shippingIncluded = shippingIncluded;
	}
	
	//constructor 6a
	/*public Product(int id, String name, String description, double price, int stock, boolean shippingIncluded) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.shippingIncluded = shippingIncluded;
	}*/
	
	//constructor 6b
	public Product(int id, String name, String description, double price, int stock, boolean shippingIncluded, Date disabledOn) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.shippingIncluded = shippingIncluded;
		this.disabledOn = disabledOn;
	}
	
	//ejercicio 6b
	public Date getDisabledOn() {
		return disabledOn;
	}

	//ejercicio 6b
	public void setDisabledOn(Date disabledOn) {
		this.disabledOn = disabledOn;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public boolean isShippingIncluded() {
		return shippingIncluded;
	}
	
	public void setShippingIncluded(boolean shippingIncluded) {
		this.shippingIncluded = shippingIncluded;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	//modificado para ej 6b
	@Override
	public String toString() {
		return String.format("Datos del producto:\nid = %s, nombre = %s, descripcion = %s, precio = %s, stock = %s, ¿envio incluido? = %s, disabledOn = %s", id,
				name, description, price, stock, shippingIncluded, disabledOn);
	}
	
	
}
