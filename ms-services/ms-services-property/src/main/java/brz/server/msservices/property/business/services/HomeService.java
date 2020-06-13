package brz.server.msservices.property.business.services;

import java.util.List;

import brz.server.msservices.property.models.home.Home;
import brz.server.msservices.property.models.home.HomeListWrapper;

public interface HomeService {
	public HomeListWrapper findAll();
	public Home findByHomeFilter(Long id, Integer cantidad);	
	public Home save(Home producto);
	public Home update(Home producto, Long id);
	
	public void delete(Long id);
}
