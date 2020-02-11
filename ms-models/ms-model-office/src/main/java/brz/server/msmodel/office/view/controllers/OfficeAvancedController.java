package brz.server.msmodel.office.view.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import brz.autoconfiguration.library.models.entities.util.PropertyListWrapper;
import brz.autoconfiguration.library.models.filter.OfficeFilter;
import brz.server.msmodel.office.business.OfficesService;

@RefreshScope
@RestController
public class OfficeAvancedController {		
	@Autowired
	private OfficesService officeService;
	
	@PostMapping(value  = "/findByFilter",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public PropertyListWrapper findByFilter(@RequestBody OfficeFilter officeFilter){
		System.out.println(officeFilter);
		return officeService.findByFilter(officeFilter);
	}
	
}