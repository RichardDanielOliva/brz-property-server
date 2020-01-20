package com.brz.commons.models.entities.property;

public class Advertiser {
	private long advertiserId;
	private String type;
	private String propertyMessage;
	
	public long getAdvertiserId() {
		return advertiserId;
	}
	public void setAdvertiserId(long advertiserId) {
		this.advertiserId = advertiserId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPropertyMessage() {
		return propertyMessage;
	}
	public void setPropertyMessage(String propertyMessage) {
		this.propertyMessage = propertyMessage;
	}
}
