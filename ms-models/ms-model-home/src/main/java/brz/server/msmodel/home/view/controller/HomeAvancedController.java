package brz.server.msmodel.home.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brz.commons.models.entities.util.PropertyList;
import com.brz.commons.models.entities.util.PropertyListWrapper;
import com.brz.commons.models.filter.HomeFilter;

import brz.server.msmodel.home.business.HomeService;
import brz.server.msmodel.home.persistence.entities.Home;
import brz.server.msmodel.home.persistence.repositories.HomeAvancedRepository;

@RefreshScope
@RestController
public class HomeAvancedController {		
	//@Autowired
	//private HomeAvancedRepository homeService;
	
	@Autowired
	private HomeService homeService;
	
	/**@PostMapping(value  = "/findByFilter",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public PropertyListWrapper findByFilter(@RequestBody HomeFilter homeFilter){
		List<Home> result = homeService.findByFilter(homeFilter);
		System.out.println(" SIZE :" + result.size());
		return new PropertyListWrapper(
				new PropertyList(result)
				);
	}*/
	
	@PostMapping(value  = "/findByFilter",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public PropertyListWrapper findByFilter(@RequestBody HomeFilter homeFilter){
		return homeService.findByFilter(homeFilter);
	}
	
}