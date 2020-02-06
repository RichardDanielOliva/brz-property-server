package brz.server.msmodel.office.business;

import com.brz.commons.models.entities.util.PropertyListWrapper;
import com.brz.commons.models.filter.HomeFilter;
import com.brz.commons.models.filter.OfficeFilter;

public interface OfficesService {
	PropertyListWrapper findByFilter(OfficeFilter officefilter);
}
