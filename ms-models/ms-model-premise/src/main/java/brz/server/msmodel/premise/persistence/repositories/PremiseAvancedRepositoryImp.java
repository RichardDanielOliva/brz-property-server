package brz.server.msmodel.premise.persistence.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import brz.autoconfiguration.library.models.entities.premise.Premise;
import brz.autoconfiguration.library.models.entities.util.Page;
import brz.autoconfiguration.library.models.entities.util.PropertyCriteriaBuilder;
import brz.autoconfiguration.library.models.entities.util.Sorted;
import brz.autoconfiguration.library.models.filter.PremiseFilter;

@Service
public class PremiseAvancedRepositoryImp implements PremiseAvancedRepository {

	private final MongoTemplate mongoTemplate;
	 
	@Autowired
	public PremiseAvancedRepositoryImp(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<Premise> findByFilter(PremiseFilter premisefilter) {
		List<Criteria> criterias = getCriteriasByFilter(premisefilter);

		
		if(0 != criterias.size()) { //Comprobamos que los criterios de la sentancia no estan vacios
			Query query = new Query();
			
			query.addCriteria(new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()])));
			
			query.with(
					PageRequest.of(
							premisefilter.getPage().getNumber(), 
							premisefilter.getPage().getSize()));
			
			return mongoTemplate.find(query, Premise.class);
		}

		return  null;
	}
	
	@Override
	public List<Criteria> getCriteriasByFilter(PremiseFilter premisefilter){
		PropertyCriteriaBuilder criteriaBuilder = new PropertyCriteriaBuilder();
		return criteriaBuilder
				.setFilter(premisefilter)
				.setCriteriaForPremiseFeature(premisefilter)
				.setCriteriaOperation()
				.setCriteriaPrice()
				.setCriteriaBuildingArea()
				.setCriteriaLocation()
				.build();
	}
	
	@Override
	public List<Premise> findByCriteriasAndPage(List<Criteria> criterias, Page page) {		
		if(0 != criterias.size()) { //Comprobamos que los criterios de la sentancia no estan vacios
			Query query = new Query();
			
			query.addCriteria(new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()])));
			
			query.with(
					PageRequest.of(
							page.getNumber(), 
							page.getSize()));
			
			return mongoTemplate.find(query, Premise.class);
		}

		return  null;
	}
	
	@Override
	public List<Premise> findByCriteriasAndPageAndSorted(List<Criteria> criterias, Page page, Sorted sorted) {		
		if(0 != criterias.size()) { //Comprobamos que los criterios de la sentancia no estan vacios
			Query query = new Query();
			
			query.addCriteria(new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()])));
			
			query.with(
					PageRequest.of(
							page.getNumber(), 
							page.getSize()));
			
			query.with(getSortByFilter(sorted));
			
			return mongoTemplate.find(query, Premise.class);
		}

		return  null;
	}
	
	private Sort getSortByFilter(Sorted sorted) {
		switch (sorted) {
		case NEWEST:
			return new Sort(Sort.Direction.ASC, "advertiser.publish_date");
		case OLDEST:
			return new Sort(Sort.Direction.DESC, "advertiser.publish_date");
		case LOWEST_PRICE:
			return new Sort(Sort.Direction.ASC, "advertiser.price");
		case HIGHEST_PRICE:
			return new Sort(Sort.Direction.DESC, "advertiser.price");

		default:
			return null;
		}
	}
	
	@Override
	public long countByCriterias(List<Criteria> criterias) {
		if(0 != criterias.size()) { //Comprobamos que los criterios de la sentancia no estan vacios
			Query query = new Query();
			
			query.addCriteria(new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()])));
			
			return mongoTemplate.count(query, Premise.class);
		}

		return  0;
	}

}	
