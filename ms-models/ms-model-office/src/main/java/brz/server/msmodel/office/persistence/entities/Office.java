package brz.server.msmodel.office.persistence.entities;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.brz.commons.models.entities.property.Property;

@Document(collection = "offices")
public class Office extends Property{
	@Id
    private String id;
	private List<Extra> extras;
	private Status status;
	
	private double buildingArea;
	private int baths;
	private int floor;
	
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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
	
}
