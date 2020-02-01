package brz.server.msmodel.home.filter;

import java.util.List;

import brz.server.msmodel.home.persistence.entities.Extra;
import brz.server.msmodel.home.persistence.entities.Type;

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
	public List<Extra> getExtras() {
		return extras;
	}
	public void setExtras(List<Extra> extras) {
		this.extras = extras;
	}
	@Override
	public String toString() {
		return "FeatureHomeFilter [rooms=" + rooms + ", baths=" + baths + ", extras=" + extras + "]";
	}
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}


	
}
