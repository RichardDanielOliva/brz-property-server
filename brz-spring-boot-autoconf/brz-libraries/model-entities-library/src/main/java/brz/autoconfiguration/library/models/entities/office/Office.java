package brz.autoconfiguration.library.models.entities.office;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import brz.autoconfiguration.library.models.entities.property.BuildingAge;
import brz.autoconfiguration.library.models.entities.property.EnergyCertificate;
import brz.autoconfiguration.library.models.entities.property.Property;
import brz.autoconfiguration.library.models.entities.property.State;

@JsonInclude(Include.NON_NULL)
@Document(collection = "offices")
public class Office extends Property implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private String id;
	private List<Extra> extras;
	private State status;
	
	@Field("building_area")
	private double buildingArea;
	private int baths;
	private int floor;
	@Field("building_age")
	private BuildingAge buildingAge;
	@Field("energy_certificate")
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
		return status;
	}
	public void setStatus(State status) {
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
