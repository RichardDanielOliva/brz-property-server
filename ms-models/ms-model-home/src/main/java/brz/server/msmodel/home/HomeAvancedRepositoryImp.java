package brz.server.msmodel.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

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
		
		criteria.add(Criteria.where(attributte).lte(value));
		
		query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		
		return mongoTemplate.find(query, Home.class);
	}

}
