package com.brz.commons.models.entities.property;

import java.util.Date;


import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Advertiser {
	@Field("user_id")
	private String userId;
	@Field("user_role")
	private UserRole userRole;
	@Field("user_contact")
	private UserContact userContact;
	@Field("property_message")
	private String propertyMessage;
	private Operation operation;
	@Field("publish_date")
	private Date publishDate;
	private float price;

	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public String getPropertyMessage() {
		return propertyMessage;
	}
	public void setPropertyMessage(String propertyMessage) {
		this.propertyMessage = propertyMessage;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public UserContact getUserContact() {
		return userContact;
	}
	public void setUserContact(UserContact userContact) {
		this.userContact = userContact;
	}
	
	
}
