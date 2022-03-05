package com.gunnertech.hfsalle.entities;

import java.io.Serializable;

public class HfInventoryEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private double price;
	private String size;
	private String type;
	private double amount;
	private String mark;

	public HfInventoryEntity() {

	}

	public HfInventoryEntity(Long id, String name, String description, double price, String size, String type, double amount,
			String mark) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.size = size;
		this.type = type;
		this.amount = amount;
		this.mark = mark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}
