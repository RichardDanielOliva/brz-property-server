package beeto.server.community.clubsmodel.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import beeto.server.community.clubsmodel.presentation.dtos.ClubResource;
import beeto.server.community.clubsmodel.presentation.services.ClubService;
import brz.autoconfiguration.library.logging.Timed;

@RestController
@RequestMapping("/club/api")
public class ClubController {
	private ClubService clubService;
	
	@Autowired
	public ClubController(ClubService clubService) {
		super();
		this.clubService = clubService;
	}

	@GetMapping("/clubs")
	@Timed
	@ResponseStatus(HttpStatus.OK)
	public List<ClubResource> findAll(){
		return clubService.findAll(); 
	}
	
	@PostMapping(value = "/clubs")
	@ResponseStatus(HttpStatus.CREATED)
	public ClubResource saveClub (@RequestBody ClubResource club){
		return clubService.insert(club); 
	}
	
	@GetMapping("/clubs/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClubResource readbook(@PathVariable("id") String clubId) throws ResourceNotFoundException{
		return clubService.findById(clubId); 
	}
}
