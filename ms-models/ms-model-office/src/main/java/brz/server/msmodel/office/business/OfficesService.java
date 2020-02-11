package brz.server.msmodel.office.business;

import brz.autoconfiguration.library.models.entities.util.PropertyListWrapper;
import brz.autoconfiguration.library.models.filter.OfficeFilter;

public interface OfficesService {
	PropertyListWrapper findByFilter(OfficeFilter officefilter);
}
