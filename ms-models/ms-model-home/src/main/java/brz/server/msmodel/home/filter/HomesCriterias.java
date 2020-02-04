package brz.server.msmodel.home.filter;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;

import com.brz.commons.models.entities.property.Operation;
import com.brz.commons.models.entities.property.State;
import com.brz.commons.models.filter.Area;
import com.brz.commons.models.filter.Location;
import com.brz.commons.models.filter.Price;

public class HomesCriterias {
	public static List<Criteria> getCriteriaForHomeFeature(FeatureHomeFilter featureHomeFilter, List<Criteria> criterias) {
		if(null != featureHomeFilter.getTypes())
			criterias.add(Criteria.where("type").in(featureHomeFilter.getTypes()));
		
		if(0 != featureHomeFilter.getBaths())
			criterias.add(Criteria.where("baths").gte(featureHomeFilter.getBaths()));
		
		if(0 != featureHomeFilter.getRooms())
			criterias.add(Criteria.where("rooms").gte(featureHomeFilter.getRooms()));
		
		if(null != featureHomeFilter.getExtras())
			criterias.add(Criteria.where("extras").in(featureHomeFilter.getExtras()));
		
		return criterias;
	}
	
	public static List<Criteria> getCriteriaOperation(Operation propertyOperation, List<Criteria> criterias) {
		if(null != propertyOperation)
			criterias.add(Criteria.where("advertiser.operation").is(propertyOperation));
		
		return criterias;
	}
	
	public static List<Criteria> getCriteriaStatus(List<State> status, List<Criteria> criterias) {
		if(null != status)
			criterias.add(Criteria.where("status").in(status));
		
		return criterias;
	}
	
	public static List<Criteria> getCriteriaPrice(Price price, List<Criteria> criterias) {
		if(null != price) {
			if(0 != price.getMin()) 
				criterias.add(Criteria.where("advertiser.price").gte(price.getMin()));
			
			if(0 != price.getMax())
				criterias.add(Criteria.where("advertiser.price").lte(price.getMax()));
		}
			
		return criterias;
	}
	
	public static List<Criteria> getCriteriaLocation(Location location, List<Criteria> criterias) {
		if(null != location) {
			System.out.println(location);
			criterias.add(Criteria.where("geometry")
							.nearSphere(
									new GeoJsonPoint(location.getCoordinates())) 
							.maxDistance(location.getMaxDistance()));
		}
			
		return criterias;
	}
	
	public static List<Criteria> getCriteriaBuildingArea(Area area, List<Criteria> criterias) {
		if(null != area) {
			if(0 != area.getFrom()) 
				criterias.add(Criteria.where("building_area").gte(area.getFrom()));
			
			if(0 != area.getTo())
				criterias.add(Criteria.where("building_area").lte(area.getTo()));
		}
			
		return criterias;
	}
}
