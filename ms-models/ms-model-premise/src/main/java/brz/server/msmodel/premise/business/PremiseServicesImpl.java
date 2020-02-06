package brz.server.msmodel.premise.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.brz.commons.models.entities.premise.Premise;
import com.brz.commons.models.entities.util.Page;
import com.brz.commons.models.entities.util.PropertyList;
import com.brz.commons.models.entities.util.PropertyListWrapper;
import com.brz.commons.models.filter.PremiseFilter;

import brz.server.msmodel.premise.persistence.repositories.PremiseAvancedRepository;

@Service
public class PremiseServicesImpl implements PremiseService {
	@Autowired
	private PremiseAvancedRepository officeRepository;

	public PremiseServicesImpl() {}

	@Override
	public PropertyListWrapper findByFilter(PremiseFilter premisefilter) {
		List<Premise> premiseList;
		List<Criteria> criterias = officeRepository.getCriteriasByFilter(premisefilter);
		Page filterPage = premisefilter.getPage();
		long totalItems = officeRepository.countByCriterias(criterias);
		
		if(null != premisefilter.getSortBy())
			premiseList = officeRepository.findByCriteriasAndPageAndSorted(criterias, filterPage, premisefilter.getSortBy());
		else
			premiseList = officeRepository.findByCriteriasAndPage(criterias, filterPage);
		
		Page page = new Page(
				filterPage.getSize(),
				totalItems,
				getTotalPage(totalItems, filterPage.getSize()),
				filterPage.getNumber()
				);
		
		return  new PropertyListWrapper(
					new PropertyList<Premise>(premiseList),
					page
				);
	}
	
	private long getTotalPage(long totalItems, int size) {
		if(0 == totalItems/size)
			return 1;
		
		return totalItems/size;
	}

}
