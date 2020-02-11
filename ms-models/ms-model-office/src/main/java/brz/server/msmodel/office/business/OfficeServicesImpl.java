package brz.server.msmodel.office.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import brz.autoconfiguration.library.models.entities.office.Office;
import brz.autoconfiguration.library.models.entities.util.Page;
import brz.autoconfiguration.library.models.entities.util.PropertyList;
import brz.autoconfiguration.library.models.entities.util.PropertyListWrapper;
import brz.autoconfiguration.library.models.filter.OfficeFilter;
import brz.server.msmodel.office.persistence.repositories.OfficeAvancedRepository;

@Service
public class OfficeServicesImpl implements OfficesService {
	@Autowired
	private OfficeAvancedRepository officeRepository;

	public OfficeServicesImpl() {}

	@Override
	public PropertyListWrapper findByFilter(OfficeFilter officefilter) {
		List<Office> officeList;
		List<Criteria> criterias = officeRepository.getCriteriasByFilter(officefilter);
		Page filterPage = officefilter.getPage();
		long totalItems = officeRepository.countByCriterias(criterias);
		
		if(null != officefilter.getSortBy())
			officeList = officeRepository.findByCriteriasAndPageAndSorted(criterias, filterPage, officefilter.getSortBy());
		else
			officeList = officeRepository.findByCriteriasAndPage(criterias, filterPage);
		
		Page page = new Page(
				filterPage.getSize(),
				totalItems,
				getTotalPage(totalItems, filterPage.getSize()),
				filterPage.getNumber()
				);
		
		return  new PropertyListWrapper(
					new PropertyList<Office>(officeList),
					page
				);
	}
	
	private long getTotalPage(long totalItems, int size) {
		if(0 == totalItems/size)
			return 1;
		
		return totalItems/size;
	}

}
