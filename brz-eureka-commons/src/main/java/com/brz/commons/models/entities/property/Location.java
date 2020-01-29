package com.brz.commons.models.entities.property;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public class Location implements Serializable{
	private String addressed;
	private String country;
	private String state;
	private String city;
	@Field("postal_code")
	private String postalCode;
	@Field("strict_id")
	private String strictId;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStrictId() {
		return strictId;
	}
	public void setStrictId(String strictId) {
		this.strictId = strictId;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getAddressed() {
		return addressed;
	}
	public void setAddressed(String addressed) {
		this.addressed = addressed;
	}

	private static final long serialVersionUID = 1L;
}
