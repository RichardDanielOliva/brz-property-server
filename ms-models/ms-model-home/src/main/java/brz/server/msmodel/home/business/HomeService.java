package brz.server.msmodel.home.business;

import brz.autoconfiguration.library.models.entities.util.PropertyListWrapper;
import brz.autoconfiguration.library.models.filter.HomeFilter;

public interface HomeService {
	PropertyListWrapper findByFilter(HomeFilter homefilter);
}
