package brz.server.msmodel.home.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import brz.autoconfiguration.library.models.entities.util.PropertyListWrapper;
import brz.autoconfiguration.library.models.filter.HomeFilter;
import brz.server.msmodel.home.business.HomeService;

@RefreshScope
@RestController
public class HomeAvancedController {			
	@Autowired
	private HomeService homeService;
	
	@PostMapping(value  = "/findByFilter",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public PropertyListWrapper findByFilter(@RequestBody HomeFilter homeFilter){
		return homeService.findByFilter(homeFilter);
	}
	
}