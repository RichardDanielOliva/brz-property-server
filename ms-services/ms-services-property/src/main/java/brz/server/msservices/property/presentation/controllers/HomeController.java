package brz.server.msservices.property.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import brz.server.msservices.property.business.services.HomeService;
import brz.server.msservices.property.models.home.HomeListWrapper;

@RefreshScope
@RestController
public class HomeController {		
	@Autowired
	@Qualifier("homeRestTemplate")
	private HomeService homeService;
	
	@GetMapping(path = "/findAll",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public HomeListWrapper listar(){
		System.out.println(homeService.findAll());
		return homeService.findAll();
	}
	
}
