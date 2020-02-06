package brz.server.msmodel.home.business;

import com.brz.commons.models.entities.util.PropertyListWrapper;
import com.brz.commons.models.filter.HomeFilter;

public interface HomeService {
	PropertyListWrapper findByFilter(HomeFilter homefilter);
}
