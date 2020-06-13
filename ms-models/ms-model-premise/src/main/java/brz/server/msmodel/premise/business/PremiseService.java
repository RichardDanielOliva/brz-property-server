package brz.server.msmodel.premise.business;

import brz.autoconfiguration.library.models.entities.util.PropertyListWrapper;
import brz.autoconfiguration.library.models.filter.PremiseFilter;

public interface PremiseService {
	PropertyListWrapper findByFilter(PremiseFilter premisefilter);
}
