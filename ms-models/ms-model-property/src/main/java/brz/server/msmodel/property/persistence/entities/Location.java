package brz.server.msmodel.property.persistence.entities;

import java.io.Serializable;

public class Location implements Serializable{
	private String country;
	private String state;
	private String city;
	private String strictId;
	private String postalCode;
	
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
	
	private static final long serialVersionUID = 1L;
}
