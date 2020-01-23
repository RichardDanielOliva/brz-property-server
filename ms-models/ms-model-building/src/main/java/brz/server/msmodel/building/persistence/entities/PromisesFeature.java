package brz.server.msmodel.building.persistence.entities;

public class PromisesFeature {
	public PromisesFeature() {}
	
	private int units;
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
