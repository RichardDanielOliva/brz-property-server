package brz.server.msmodel.premise.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;

import brz.autoconfiguration.library.models.entities.premise.Premise;
import brz.autoconfiguration.library.models.entities.util.Page;
import brz.autoconfiguration.library.models.entities.util.Sorted;
import brz.autoconfiguration.library.models.filter.PremiseFilter;

public interface PremiseAvancedRepository {
	List<Premise> findByFilter(PremiseFilter premisefilter);
	List<Criteria> getCriteriasByFilter(PremiseFilter premisefilter);
	long countByCriterias(List<Criteria> criterias);
	List<Premise> findByCriteriasAndPage(List<Criteria> criterias, Page page);
	List<Premise> findByCriteriasAndPageAndSorted(List<Criteria> criterias, Page page, Sorted sorted);
}
