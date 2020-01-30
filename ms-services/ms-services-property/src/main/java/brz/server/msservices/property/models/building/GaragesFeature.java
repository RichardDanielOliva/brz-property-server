package brz.server.msservices.property.models.building;

import org.springframework.data.mongodb.core.mapping.Field;

public class GaragesFeature {

	public GaragesFeature() {	}

	private int units;	
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
