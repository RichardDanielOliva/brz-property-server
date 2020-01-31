package brz.server.msmodel.home.persistence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import brz.server.msmodel.home.persistence.entities.Home;
import brz.server.msmodel.home.persistence.repositories.HomeAvancedRepository;

@RefreshScope
@RestController
public class HomeAvancedController {		
	@Autowired
	private HomeAvancedRepository homeService;
	
	@GetMapping(value  = "/query/{attributte}/{value}",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Home> listar(@PathVariable final String attributte, 
			@PathVariable final int value){
		System.out.println("Hello " + attributte + "   " + value);
		
		List<Home> result = homeService.query(attributte, value);
		return result;
	}
	
}