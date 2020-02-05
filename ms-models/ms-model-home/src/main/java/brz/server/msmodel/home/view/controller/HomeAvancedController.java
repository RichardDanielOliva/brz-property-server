package brz.server.msmodel.home.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brz.commons.models.filter.HomeFilter;

import brz.server.msmodel.home.persistence.entities.Home;
import brz.server.msmodel.home.persistence.repositories.HomeAvancedRepository;
import brz.server.msmodel.home.view.dto.HomeList;
import brz.server.msmodel.home.view.dto.HomeListWrapper;

@RefreshScope
@RestController
public class HomeAvancedController {		
	@Autowired
	private HomeAvancedRepository homeService;
	
	@GetMapping(value  = "/query/{attributte}/{value}",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Home> listar(@PathVariable final String attributte, 
			@PathVariable final int value){
		
		List<Home> result = homeService.query(attributte, value);
		return result;
	}
	
	@PostMapping(value  = "/findByFilter",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public HomeListWrapper findByFilter(@RequestBody HomeFilter homeFilter){
		List<Home> result = homeService.findByFilter(homeFilter);
		System.out.println(" SIZE :" + result.size());
		return new HomeListWrapper(
				new HomeList(result)
				);
	}
	
}