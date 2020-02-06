package brz.server.msmodel.premise.business;

import com.brz.commons.models.entities.util.PropertyListWrapper;
import com.brz.commons.models.filter.HomeFilter;
import com.brz.commons.models.filter.OfficeFilter;
import com.brz.commons.models.filter.PremiseFilter;

public interface PremiseService {
	PropertyListWrapper findByFilter(PremiseFilter premisefilter);
}
