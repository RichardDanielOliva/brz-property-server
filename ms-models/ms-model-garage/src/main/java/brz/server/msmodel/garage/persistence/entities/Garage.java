package brz.server.msmodel.garage.persistence.entities;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.brz.commons.models.entities.property.Property;
import com.brz.commons.models.entities.property.State;

@Document(collection = "offices")
public class Garage extends Property{
	@Id
    private String id;
	private State status;
	private int floor;
	
	private List<Extra> extras;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public State getStatus() {
		return status;
	}
	public void setStatus(State status) {
		this.status = status;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public List<Extra> getExtras() {
		return extras;
	}
	public void setExtras(List<Extra> extras) {
		this.extras = extras;
	}
	
}
