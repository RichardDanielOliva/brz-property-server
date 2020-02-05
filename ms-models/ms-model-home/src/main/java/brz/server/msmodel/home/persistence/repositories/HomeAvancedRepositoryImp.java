package brz.server.msmodel.home.persistence.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.brz.commons.models.entities.util.PropertyCriteriaBuilder;
import com.brz.commons.models.filter.HomeFilter;


import brz.server.msmodel.home.persistence.entities.Home;
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
		PropertyCriteriaBuilder criteriaBuilder = new PropertyCriteriaBuilder();
		Query query = new Query();
		
		List<Criteria> criterias = criteriaBuilder
										.setFilter(homefilter)
										.setCriteriaForHomeFeature(homefilter)
										.setCriteriaOperation()
										.setCriteriaStatus()
										.setCriteriaPrice()
										.setCriteriaBuildingArea()
										.setCriteriaLocation()
										.build();

		
		if(0 != criterias.size()) { //Comprobamos que los criterios de la sentancia no estan vacios
			query.addCriteria(new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()])));
			
			System.out.println("CRITERIA SIZE" + criterias.size());
			
			System.out.println(query);
			
			return mongoTemplate.find(query, Home.class);
		}

		return  null;
	}
}	
