package beeto.server.community.clubsmodel.presentation.services;

import java.util.List;

import beeto.server.community.clubsmodel.presentation.dtos.ClubResource;
import brz.autoconfiguration.exceptionhandler.ResourceNotFoundException;

public interface ClubService {
	ClubResource findById(String clubId)  throws ResourceNotFoundException;
	
	ClubResource insert(ClubResource club);

	List<ClubResource> findAll();

	void delete(int clubId);

	void update(ClubResource Club, int clubId);
}
