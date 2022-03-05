package com.gunnertech.hfsalle.entities;

import java.io.Serializable;

public class HfSalleEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private double price;
	private double amount;
	
	public HfSalleEntity() {
		
	}
	
	public HfSalleEntity(String name, double price, double amount) {
		super();
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	public double getTotal() {
		return price * amount;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
