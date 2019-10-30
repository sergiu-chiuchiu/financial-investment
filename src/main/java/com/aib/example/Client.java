package com.aib.example;

public class Client {
	private String name;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Client(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
