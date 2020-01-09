package beeto.server.community.clubsmodel.business.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import beeto.server.community.clubsmodel.business.assemblers.ClubResourceAssembler;
import beeto.server.community.clubsmodel.persistence.entities.Club;
import beeto.server.community.clubsmodel.persistence.repositories.ClubRepository;
import beeto.server.community.clubsmodel.presentation.dtos.ClubResource;
import beeto.server.community.clubsmodel.presentation.services.ClubService;

@Component
public class ClubServiceImp implements ClubService {
	ClubRepository clubRepository;
	ClubResourceAssembler clubAssembler;
	
	@Autowired
	public ClubServiceImp(ClubRepository clubRepository, ClubResourceAssembler clubAssembler) {
		super();
		this.clubRepository = clubRepository;
		this.clubAssembler = clubAssembler;
	}

	@Override
	public ClubResource findById(String clubId) throws ResourceNotFoundException {		
		return clubRepository.findById(clubId)
					.map(clubAssembler :: toResource)
					.orElseThrow(()-> new ResourceNotFoundException());
	}

	@Override
	public ClubResource insert(ClubResource clubResource) {
		Club club = clubAssembler.toModelDB(clubResource);
		System.out.println(club);
		clubRepository.save(
				club
				);
		
		return null;
	}

	@Override
	public List<ClubResource> findAll() {
		return clubRepository.findAll()
				.stream()
				.map(clubAssembler :: toResource)
				.collect(Collectors.toCollection(() -> new ArrayList<ClubResource>()));
	}

	@Override
	public void delete(int clubId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ClubResource Club, int clubId) {
		// TODO Auto-generated method stub

	}

}
