package brz.server.msmodel.home.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;

import brz.autoconfiguration.library.models.entities.home.Home;
import brz.autoconfiguration.library.models.entities.util.Page;
import brz.autoconfiguration.library.models.entities.util.Sorted;
import brz.autoconfiguration.library.models.filter.HomeFilter;

public interface HomeAvancedRepository {
	List<Home> findByFilter(HomeFilter homefilter);
	List<Criteria> getCriteriasByFilter(HomeFilter homefilter);
	long countByCriterias(List<Criteria> criterias);
	List<Home> findByCriteriasAndPage(List<Criteria> criterias, Page page);
	List<Home> findByCriteriasAndPageAndSorted(List<Criteria> criterias, Page page, Sorted sorted);
}
