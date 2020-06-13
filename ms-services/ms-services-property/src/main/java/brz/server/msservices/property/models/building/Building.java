package brz.server.msservices.property.models.building;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.brz.commons.models.entities.property.BuildingAge;
import com.brz.commons.models.entities.property.Property;
import com.brz.commons.models.entities.property.State;

public class Building extends Property{
    private String id;

	private State status;
	private double buildingArea;
	private OfficesFeature officesFeature;
	private HomesFeature homesFeature;
	private PromisesFeature promisesFeature;
	private GaragesFeature garagesFeature;

	private BuildingAge buildingAge;
	
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
	public double getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(double buildingArea) {
		this.buildingArea = buildingArea;
	}

	public BuildingAge getBuildingAge() {
		return buildingAge;
	}
	public void setBuildingAge(BuildingAge buildingAge) {
		this.buildingAge = buildingAge;
	}
	public OfficesFeature getOfficesFeature() {
		return officesFeature;
	}
	public void setOfficesFeature(OfficesFeature officesFeature) {
		this.officesFeature = officesFeature;
	}
	public HomesFeature getHomesFeature() {
		return homesFeature;
	}
	public void setHomesFeature(HomesFeature homesFeature) {
		this.homesFeature = homesFeature;
	}
	public PromisesFeature getPromisesFeature() {
		return promisesFeature;
	}
	public void setPromisesFeature(PromisesFeature promisesFeature) {
		this.promisesFeature = promisesFeature;
	}
	public GaragesFeature getGaragesFeature() {
		return garagesFeature;
	}
	public void setGaragesFeature(GaragesFeature garagesFeature) {
		this.garagesFeature = garagesFeature;
	}
}
