package com.gunnerapis.hfpartners.entities;

public abstract class PartnerEntity {
	
	public Long id;
	public String name;
	public String address;
	public String phone;
	public String postalCode;
	public String city;
	public String district;
	public String reference;
	
	public PartnerEntity() {

	}	
	
	public PartnerEntity(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public PartnerEntity(Long id, String name, String address, String phone, String postalCode, String city,
			String district, String reference) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.postalCode = postalCode;
		this.city = city;
		this.district = district;
		this.reference = reference;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}	

}
