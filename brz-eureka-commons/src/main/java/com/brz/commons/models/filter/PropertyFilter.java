package com.brz.commons.models.filter;

import java.util.List;

import com.brz.commons.models.entities.property.Operation;
import com.brz.commons.models.entities.property.PropertyType;
import com.brz.commons.models.entities.property.State;

public class PropertyFilter {
	private PropertyType type;
	private Operation operation;
	private Price price;
	private Area area;
	private List<State> status;
	public PropertyType getType() {
		return type;
	}
	public void setType(PropertyType type) {
		this.type = type;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public List<State> getStatus() {
		return status;
	}
	public void setStatus(List<State> status) {
		this.status = status;
	}
	

	
	
}
