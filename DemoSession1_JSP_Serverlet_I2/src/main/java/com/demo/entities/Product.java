package com.demo.entities;

public class Product {
	private int id;
	private String name;
	private double price;
	private int quantity;
	private boolean status;
	private String photo;
	private Category category;
	
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	//////////////////////////
	public Product(int id, String name, double price, int quantity, boolean status, String photo, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.photo = photo;
		this.category = category;
	}
	///////////////////////////////////////////
	public Product(int id, String name, double price, int quantity, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}
	
	public Product() {
		super();
	}
	
}
