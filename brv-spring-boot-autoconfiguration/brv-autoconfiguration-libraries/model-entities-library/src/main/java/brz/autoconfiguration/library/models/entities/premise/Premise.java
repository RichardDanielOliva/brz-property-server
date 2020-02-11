package brz.autoconfiguration.library.models.entities.premise;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import brz.autoconfiguration.library.models.entities.property.BuildingAge;
import brz.autoconfiguration.library.models.entities.property.EnergyCertificate;
import brz.autoconfiguration.library.models.entities.property.Property;
import brz.autoconfiguration.library.models.entities.property.State;

@Document(collection = "promises")
public class Premise extends Property{
	@Id
    private String id;
	private List<Extra> extras;
	private State state;
	
	private double buildingArea;
	private int baths;
	private int floor;
	
	private Type type;
	
	private BuildingAge buildingAge;
	private EnergyCertificate energyCertificate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Extra> getExtras() {
		return extras;
	}
	public void setExtras(List<Extra> extras) {
		this.extras = extras;
	}
	public State getStatus() {
		return state;
	}
	public void setStatus(State status) {
		this.state = status;
	}
	public double getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(double buildingArea) {
		this.buildingArea = buildingArea;
	}
	public int getBaths() {
		return baths;
	}
	public void setBaths(int baths) {
		this.baths = baths;
	}
	public BuildingAge getBuildingAge() {
		return buildingAge;
	}
	public void setBuildingAge(BuildingAge buildingAge) {
		this.buildingAge = buildingAge;
	}
	public EnergyCertificate getEnergyCertificate() {
		return energyCertificate;
	}
	public void setEnergyCertificate(EnergyCertificate energyCertificate) {
		this.energyCertificate = energyCertificate;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
}
