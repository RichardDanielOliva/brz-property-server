package brz.server.msmodel.home.filter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

public class MyOwnCriteria extends Criteria {
	private @Nullable String key;
	private List<Criteria> criteriaChain;
	private LinkedHashMap<String, Object> criteria = new LinkedHashMap<String, Object>();
	
	public MyOwnCriteria() {
		this.criteriaChain = new ArrayList<Criteria>();
	}
	
	public MyOwnCriteria(String key) {
		this.criteriaChain = new ArrayList<Criteria>();
		this.criteriaChain.add(this);
		this.key = key;
	}
	
	protected MyOwnCriteria(List<Criteria> criteriaChain, String key) {
		this.criteriaChain = criteriaChain;
		this.criteriaChain.add(this);
		this.key = key;
	}
	
	public static Criteria where(String key) {
		return new MyOwnCriteria(key);
	}
	
	public Criteria nearGeometry(Point point) {

		Assert.notNull(point, "Point must not be null!");

		criteria.put("$nearSphere",  "$geometry: {type: 'Point' , coordinates:  [ 42.880619, -8.54661 ]}, $maxDistance: 5");
		//		"       $geometry: {" + 
		//		"          type: \"Point\" ," + 
		//		"          coordinates:  [ " + point.getX() + "," +  point.getY() + "]" + 
		//		"       }," + 
		//		"       $maxDistance: 500");
		return this;
	}


}
