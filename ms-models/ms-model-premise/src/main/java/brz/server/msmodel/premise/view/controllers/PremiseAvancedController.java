package brz.server.msmodel.premise.view.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import brz.autoconfiguration.library.models.entities.util.PropertyListWrapper;
import brz.autoconfiguration.library.models.filter.PremiseFilter;
import brz.server.msmodel.premise.business.PremiseService;

@RefreshScope
@RestController
public class PremiseAvancedController {		
	@Autowired
	private PremiseService premiseService;
	
	@PostMapping(value  = "/findByFilter",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public PropertyListWrapper findByFilter(@RequestBody PremiseFilter premisefilter){
		System.out.println(premisefilter);
		return premiseService.findByFilter(premisefilter);
	}
	
}