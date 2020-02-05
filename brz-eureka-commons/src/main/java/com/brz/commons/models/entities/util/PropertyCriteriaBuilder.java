package com.brz.commons.models.entities.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;

import com.brz.commons.models.filter.HomeFilter;
import com.brz.commons.models.filter.PropertyFilter;


public class PropertyCriteriaBuilder {
	protected List<Criteria> criterias;
	protected PropertyFilter filter;
	
	public PropertyCriteriaBuilder(){
		this.criterias = new ArrayList<Criteria>();
	}
	
	public PropertyCriteriaBuilder setCriteriaOperation() {
		System.out.println(filter);
		if(null != filter.getOperation())
			criterias.add(Criteria.where("advertiser.operation").is(filter.getOperation()));
		
		return this;
	}
	
	public List<Criteria> build(){
		return criterias;
	}
	
	public PropertyCriteriaBuilder setFilter(PropertyFilter filter) {
		this.filter = filter;
		return this;
	}
	
	public PropertyCriteriaBuilder setCriteriaStatus() {
		if(null != filter.getStatus())
			criterias.add(Criteria.where("status").in(filter.getStatus()));
		
		return this;
	}
	
	public PropertyCriteriaBuilder setCriteriaPrice() {
		if(null != filter.getPrice()) {
			if(0 != filter.getPrice().getMin()) 
				criterias.add(Criteria.where("advertiser.price").gte(filter.getPrice().getMin()));
			
			if(0 != filter.getPrice().getMax())
				criterias.add(Criteria.where("advertiser.price").lte(filter.getPrice().getMax()));
		}
			
		return this;
	}
	
	public PropertyCriteriaBuilder setCriteriaLocation() {
		if(null != filter.getLocation()) {
			System.out.println(filter.getLocation());
			criterias.add(Criteria.where("geometry")
							.nearSphere(
									new GeoJsonPoint(filter.getLocation().getCoordinates())) 
							.maxDistance(filter.getLocation().getMaxDistance()));
		}
			
		return this;
	}
	
	public PropertyCriteriaBuilder setCriteriaBuildingArea() {
		if(null != filter.getArea()) {
			if(0 != filter.getArea().getFrom()) 
				criterias.add(Criteria.where("building_area").gte(filter.getArea().getFrom()));
			
			if(0 != filter.getArea().getTo())
				criterias.add(Criteria.where("building_area").lte(filter.getArea().getTo()));
		}
			
		return this;
	}
	
	public PropertyCriteriaBuilder setCriteriaForHomeFeature(HomeFilter homeFilter) {
		if(null != homeFilter.getFeatures()) {
		
			if(null != homeFilter.getFeatures().getTypes())
				criterias.add(Criteria.where("type").in(homeFilter.getFeatures().getTypes()));
			
			if(0 != homeFilter.getFeatures().getBaths())
				criterias.add(Criteria.where("baths").gte(homeFilter.getFeatures().getBaths()));
			
			if(0 != homeFilter.getFeatures().getRooms())
				criterias.add(Criteria.where("rooms").gte(homeFilter.getFeatures().getRooms()));
			
			if(null != homeFilter.getFeatures().getExtras())
				criterias.add(Criteria.where("extras").in(homeFilter.getFeatures().getExtras()));
			
			}
		
		return this;
	}


}
