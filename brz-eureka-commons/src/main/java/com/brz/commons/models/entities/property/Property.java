package com.brz.commons.models.entities.property;

public class Property {
	private String cadastralReference;
	private String comment;
	private float area;
	private Location location;
	private Advertiser advertiser;
	
	public String getCadastralReference() {
		return cadastralReference;
	}
	public void setCadastralReference(String cadastralReference) {
		this.cadastralReference = cadastralReference;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Advertiser getAdvertiser() {
		return advertiser;
	}
	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
	}
	
	
}
