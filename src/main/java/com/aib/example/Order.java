package com.aib.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Order {
	
	private Client client;
//	public Client getClient() {
//		return client;
//	}
//	public void setClient(Client client) {
//		this.client = client;
//	}
	private Integer id;
	private Date orderDate;
	private List<Article> articles=new ArrayList<Article>();

//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public Date getOrderDate() {
//		return orderDate;
//	}
//	public void setOrderDate(Date orderDate) {
//		this.orderDate = orderDate;
//	}
//	public List<Article> getArticles() {
//		return articles;
//	}
//	public void setArticles(List<Article> articles) {
//		this.articles = articles;
//	}

	public Order(Client client, Integer id, Date orderDate) {
		super();
		this.client = client;
		this.id = id;
		this.orderDate = orderDate;
		
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//private Double orderValue;
	public Double getOrderValue() {
		Double value=0.0;
		for(Article a:articles)
			value+=(a.getQuantity()*a.getProduct().getPrice())-this.discount*(a.getQuantity()*a.getProduct().getPrice());
		return value;
	}

	private Double discount;
//	public Double getDiscount() {
//		return discount;
//	}
//	public void setDiscount(Double discount) {
//		this.discount = discount;
//	}
	
	

}
