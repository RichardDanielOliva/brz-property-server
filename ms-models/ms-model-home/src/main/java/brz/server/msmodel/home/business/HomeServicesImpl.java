package brz.server.msmodel.home.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.brz.commons.models.entities.util.Page;
import com.brz.commons.models.entities.util.PropertyList;
import com.brz.commons.models.entities.util.PropertyListWrapper;
import com.brz.commons.models.filter.HomeFilter;

import brz.server.msmodel.home.persistence.entities.Home;
import brz.server.msmodel.home.persistence.repositories.HomeAvancedRepository;

@Service
public class HomeServicesImpl implements HomeService {
	@Autowired
	private HomeAvancedRepository homeRepository;

	public HomeServicesImpl() {}

	@Override
	public PropertyListWrapper findByFilter(HomeFilter homefilter) {
		List<Home> homeList;
		List<Criteria> criterias = homeRepository.getCriteriasByFilter(homefilter);
		Page filterPage = homefilter.getPage();
		long totalItems = homeRepository.countByCriterias(criterias);
		
		if(null != homefilter.getSortBy())
			homeList = homeRepository.findByCriteriasAndPageAndSorted(criterias, filterPage, homefilter.getSortBy());
		else
			homeList = homeRepository.findByCriteriasAndPage(criterias, filterPage);
		
		Page page = new Page(
				filterPage.getSize(),
				totalItems,
				getTotalPage(totalItems, filterPage.getSize()),
				filterPage.getNumber()
				);
		
		return  new PropertyListWrapper(
					new PropertyList<Home>(homeList),
					page
				);
	}
	
	private long getTotalPage(long totalItems, int size) {
		if(0 == totalItems/size)
			return 1;
		
		return totalItems/size;
	}

}
