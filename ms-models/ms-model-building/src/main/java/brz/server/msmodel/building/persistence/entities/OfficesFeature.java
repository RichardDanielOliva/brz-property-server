package brz.server.msmodel.building.persistence.entities;

import org.springframework.data.mongodb.core.mapping.Field;

public class OfficesFeature {

	public OfficesFeature() {}

	private int units;
	@Field("total_area")
	private float totalArea;
	
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public float getTotalArea() {
		return totalArea;
	}
	public void setTotalArea(float totalArea) {
		this.totalArea = totalArea;
	}
}
