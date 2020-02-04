package brz.server.msmodel.home.persistence.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.brz.commons.models.entities.property.Geometry;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;

import brz.server.msmodel.home.filter.HomeFilter;
import brz.server.msmodel.home.filter.HomesCriterias;
import brz.server.msmodel.home.persistence.entities.Home;
import brz.server.msmodel.home.persistence.entities.Type;
import brz.server.msmodel.home.persistence.repositories.HomeAvancedRepository;

@Service
public class HomeAvancedRepositoryImp implements HomeAvancedRepository {

	private final MongoTemplate mongoTemplate;
	 
	@Autowired
	public HomeAvancedRepositoryImp(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public List<Home> query(String attributte, int value) {
		Query query = new Query();
		List<Criteria> criteria = new ArrayList<>();
		
		criteria.add(
				Criteria.where(attributte).lte(value));
		
		query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		
		return mongoTemplate.find(query, Home.class);
	}

	@Override
	public List<Home> findByFilter(HomeFilter homefilter) {
		Query query = new Query();
		List<Criteria> criterias = new ArrayList<>();
		
		if(null != homefilter.getFeatures()) //Comprobamos las caracteristicas particulares de la casa.
			criterias = HomesCriterias.getCriteriaForHomeFeature(homefilter.getFeatures(), criterias);
		
		if(null != homefilter.getOperation())
			criterias = HomesCriterias.getCriteriaOperation(homefilter.getOperation(), criterias);
		
		if(null != homefilter.getStatus())
			criterias = HomesCriterias.getCriteriaStatus(homefilter.getStatus(), criterias);
		
		if(null != homefilter.getPrice())
			criterias = HomesCriterias.getCriteriaPrice(homefilter.getPrice(), criterias);
		
		if(null != homefilter.getArea())
			criterias = HomesCriterias.getCriteriaBuildingArea(homefilter.getArea(), criterias);
		
		if(null != homefilter.getLocation())
			criterias = HomesCriterias.getCriteriaLocation(homefilter.getLocation(), criterias);
		
		if(0 != criterias.size()) { //Comprobamos que los criterios de la sentancia no estan vacios
			query.addCriteria(new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()])));
			System.out.println(criterias.toArray(new Criteria[criterias.size()]));
			//mongoTemplate.indexOps(Home.class).ensureIndex(new GeospatialIndex("geometry.coordinates").named("geometry.coordinates_2d").typed(GeoSpatialIndexType.GEO_2D));
			
			//NearQuery nearQuery = NearQuery.near(homefilter.getLocation().getCoordinates().getX(), homefilter.getLocation().getCoordinates().getY());
			
			//nearQuery.maxDistance(0.005);
			//nearQuery.query(query);
			//return mongoTemplate.geoNear(nearQuery, Home.class)
				//	.getContent().stream().map(GeoResult::getContent).collect(Collectors.toList());
			
			return mongoTemplate.find(query, Home.class);
		}

		return  null;
	}
}	
