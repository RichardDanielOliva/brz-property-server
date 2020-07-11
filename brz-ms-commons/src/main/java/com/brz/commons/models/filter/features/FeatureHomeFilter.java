package com.brz.commons.models.filter.features;

import java.util.List;

import com.brz.commons.models.entities.home.Extra;
import com.brz.commons.models.entities.home.Type;

public class FeatureHomeFilter {
	private List<Type> types;
	private int rooms;
	private int baths;
	private List<Extra> extras;
	
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public int getBaths() {
		return baths;
	}
	public void setBaths(int baths) {
		this.baths = baths;
	}
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	public List<Extra> getExtras() {
		return extras;
	}
	public void setExtras(List<Extra> extras) {
		this.extras = extras;
	}


	
}
