package com.brz.commons.models.filter;

import org.springframework.data.geo.Point;

public class Location {
	private String type;
	private Point coordinates;
	private double maxDistance;
	private double minDistance;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Point getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Point coordinates) {
		this.coordinates = coordinates;
	}

	public double getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}

	public double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	public Location() {}

	@Override
	public String toString() {
		return "Location [type=" + type + ", coordinates=" + coordinates + ", maxDistance=" + maxDistance
				+ ", minDistance=" + minDistance + "]";
	}
	
}
