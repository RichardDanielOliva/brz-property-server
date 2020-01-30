package brz.server.msservices.property.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import brz.server.msservices.property.models.home.HomeListWrapper;
import brz.server.msservices.property.models.home.Home;
import brz.server.msservices.property.models.home.HomeList;

@Service("homeRestTemplate")
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public HomeListWrapper findAll() {
		return restTemplate.getForObject(
					"http://ms-model-home/homes",
					HomeListWrapper.class);
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

	public HomeServiceImpl() {}

}
