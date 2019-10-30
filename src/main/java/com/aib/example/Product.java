package com.aib.example;

public class Product {
	private String name;
	private String type;
	private Double price;
	//private Double discount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	/*
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	*/
	public Product(String name, String type, Double price) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
