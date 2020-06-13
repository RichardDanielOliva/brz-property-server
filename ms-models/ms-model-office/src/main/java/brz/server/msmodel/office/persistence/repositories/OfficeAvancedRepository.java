package brz.server.msmodel.office.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;

import brz.autoconfiguration.library.models.entities.office.Office;
import brz.autoconfiguration.library.models.entities.util.Page;
import brz.autoconfiguration.library.models.entities.util.Sorted;
import brz.autoconfiguration.library.models.filter.OfficeFilter;

public interface OfficeAvancedRepository {
	List<Office> findByFilter(OfficeFilter officefilter);
	List<Criteria> getCriteriasByFilter(OfficeFilter officefilter);
	long countByCriterias(List<Criteria> criterias);
	List<Office> findByCriteriasAndPage(List<Criteria> criterias, Page page);
	List<Office> findByCriteriasAndPageAndSorted(List<Criteria> criterias, Page page, Sorted sorted);
}
