package com.gunnerapis.hfpartners.entities;

public class CustomerEntity extends PartnerEntity {
	
	private String partnerType;
	
	public CustomerEntity() {
		
	}
	
	public CustomerEntity(String name, String city) {
		super(name, city);
	}

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}		
	
}
