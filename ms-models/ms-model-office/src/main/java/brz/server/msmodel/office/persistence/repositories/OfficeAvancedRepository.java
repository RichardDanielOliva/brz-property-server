package brz.server.msmodel.office.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;

import com.brz.commons.models.entities.util.Page;
import com.brz.commons.models.entities.util.Sorted;
import com.brz.commons.models.filter.OfficeFilter;

import brz.server.msmodel.office.persistence.entities.Office;

public interface OfficeAvancedRepository {
	List<Office> findByFilter(OfficeFilter officefilter);
	List<Criteria> getCriteriasByFilter(OfficeFilter officefilter);
	long countByCriterias(List<Criteria> criterias);
	List<Office> findByCriteriasAndPage(List<Criteria> criterias, Page page);
	List<Office> findByCriteriasAndPageAndSorted(List<Criteria> criterias, Page page, Sorted sorted);
}
