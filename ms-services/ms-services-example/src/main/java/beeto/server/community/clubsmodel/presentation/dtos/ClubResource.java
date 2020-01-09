package beeto.server.community.clubsmodel.presentation.dtos;

import java.util.Set;

import org.springframework.hateoas.ResourceSupport;

import beeto.server.community.clubsmodel.persistence.entities.Location;
import beeto.server.community.clubsmodel.persistence.entities.Sport;

public class ClubResource extends ResourceSupport{ 

    private String clubId;
    private String title;
    private String description;
    private String imageUrl; //provisional 
	private Set<Sport> sports;
	private Location locations;
	
	public String getClubId() {
		return clubId;
	}
	public void setClubId(String clubId) {
		this.clubId = clubId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Set<Sport> getSports() {
		return sports;
	}
	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}
	public Location getLocations() {
		return locations;
	}
	public void setLocations(Location locations) {
		this.locations = locations;
	}
	
	
}
