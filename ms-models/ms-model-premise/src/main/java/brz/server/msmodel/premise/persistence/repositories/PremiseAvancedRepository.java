package brz.server.msmodel.premise.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;

import com.brz.commons.models.entities.premise.Premise;
import com.brz.commons.models.entities.util.Page;
import com.brz.commons.models.entities.util.Sorted;
import com.brz.commons.models.filter.PremiseFilter;

public interface PremiseAvancedRepository {
	List<Premise> findByFilter(PremiseFilter premisefilter);
	List<Criteria> getCriteriasByFilter(PremiseFilter premisefilter);
	long countByCriterias(List<Criteria> criterias);
	List<Premise> findByCriteriasAndPage(List<Criteria> criterias, Page page);
	List<Premise> findByCriteriasAndPageAndSorted(List<Criteria> criterias, Page page, Sorted sorted);
}
