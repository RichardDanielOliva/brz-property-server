package brz.server.msmodel.property.persistence.entities;

public class Build {
	private int propertyFloorNumber;
	private boolean elevator;
	
	public Build() {}
	
	public int getPropertyFloorNumber() {
		return propertyFloorNumber;
	}

	public void setPropertyFloorNumber(int propertyFloorNumber) {
		this.propertyFloorNumber = propertyFloorNumber;
	}

	public boolean isElevator() {
		return elevator;
	}

	public void setElevator(boolean elevator) {
		this.elevator = elevator;
	}
}
