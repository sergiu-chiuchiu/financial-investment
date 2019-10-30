package com.aib.example;

public class Article {
	private Product product;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(Product product, Order order, Double quantity) {
		super();
		this.product = product;
		this.order = order;
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	private Order order;
	private Double quantity;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	

}
