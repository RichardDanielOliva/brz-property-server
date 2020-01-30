package brz.server.msservices.property.business.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brz.server.msservices.property.clients.HomeFeignClient;
import brz.server.msservices.property.models.home.Home;
import brz.server.msservices.property.models.home.HomeListWrapper;


@Service("homeFeign")
public class HomeServiceFeign implements HomeService {
	
	@Autowired
	HomeFeignClient homeClient;

	@Override
	public HomeListWrapper findAll() {
		return homeClient.findAll();
	}

	@Override
	public Home findByHomeFilter(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Home save(Home producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Home update(Home producto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
