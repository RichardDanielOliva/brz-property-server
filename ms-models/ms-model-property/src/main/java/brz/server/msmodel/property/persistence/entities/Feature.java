package brz.server.msmodel.property.persistence.entities;

import java.util.Date;

public class Feature {
	private double m2;
	private double buildM2;
	private int rooms;
	private int toilets;
	private Date buildDate;
	private boolean garage;
	
	public Feature() {}

	public double getM2() {
		return m2;
	}

	public void setM2(double m2) {
		this.m2 = m2;
	}

	public double getBuildM2() {
		return buildM2;
	}

	public void setBuildM2(double buildM2) {
		this.buildM2 = buildM2;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getToilets() {
		return toilets;
	}

	public void setToilets(int toilets) {
		this.toilets = toilets;
	}

	public Date getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}

	public boolean isGarage() {
		return garage;
	}

	public void setGarage(boolean garage) {
		this.garage = garage;
	}

}
