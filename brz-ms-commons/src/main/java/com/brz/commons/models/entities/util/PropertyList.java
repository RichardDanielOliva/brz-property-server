package com.brz.commons.models.entities.util;

import java.util.ArrayList;
import java.util.List;

public class PropertyList<T>{
    private List<T> properties;
    
	public PropertyList() {
		setProperties(new ArrayList<>());
	}
	
	public PropertyList(List<T> properties) {
		this.properties = properties;
	}

	public List<T> getProperties() {
		return properties;
	}

	public void setProperties(List<T> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "PropertyList [properties=" + properties + "]";
	}

	
}
