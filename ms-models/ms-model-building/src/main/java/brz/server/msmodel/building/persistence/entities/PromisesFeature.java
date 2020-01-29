package brz.server.msmodel.building.persistence.entities;

import org.springframework.data.mongodb.core.mapping.Field;

public class PromisesFeature {
	public PromisesFeature() {}
	
	private int units;
	@Field("total_area")
	private float totalArea;
	
	public float getTotalArea() {
		return totalArea;
	}
	public void setTotalArea(float totalArea) {
		this.totalArea = totalArea;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	
	
}
