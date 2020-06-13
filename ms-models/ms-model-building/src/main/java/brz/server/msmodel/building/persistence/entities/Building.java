package brz.server.msmodel.building.persistence.entities;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.brz.commons.models.entities.property.BuildingAge;
import com.brz.commons.models.entities.property.Property;
import com.brz.commons.models.entities.property.State;

@Document(collection = "buildings")
public class Building extends Property{
	@Id
    private String id;

	private State status;
	
	@Field("building_area")
	private double buildingArea;
	
	@Field("offices_feature")
	private OfficesFeature officesFeature;
	@Field("homes_feature")
	private HomesFeature homesFeature;
	@Field("promises_feature")
	private PromisesFeature promisesFeature;
	@Field("garages_feature")
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
