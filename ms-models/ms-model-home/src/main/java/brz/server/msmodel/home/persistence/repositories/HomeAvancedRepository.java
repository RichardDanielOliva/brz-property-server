package brz.server.msmodel.home.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;

import com.brz.commons.models.entities.util.Page;
import com.brz.commons.models.entities.util.Sorted;
import com.brz.commons.models.filter.HomeFilter;

import brz.server.msmodel.home.persistence.entities.Home;

public interface HomeAvancedRepository {
	List<Home> findByFilter(HomeFilter homefilter);
	List<Criteria> getCriteriasByFilter(HomeFilter homefilter);
	long countByCriterias(List<Criteria> criterias);
	List<Home> findByCriteriasAndPage(List<Criteria> criterias, Page page);
	List<Home> findByCriteriasAndPageAndSorted(List<Criteria> criterias, Page page, Sorted sorted);
}
