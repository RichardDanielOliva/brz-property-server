package brz.server.msmodel.example.persistence.entities;

import java.util.Set;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "community-entity")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class CommunityEntity {
	@Id
    private String id;
    private String title;
    private String description;
    private String imageUrl; //provisional
    private Location locations;
	private Set<Sport> sports;
	
	//Ref
    private Set<String> userIds;
    private Set<String> activityIds;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Location getLocations() {
		return locations;
	}
	public void setLocations(Location locations) {
		this.locations = locations;
	}
	public Set<Sport> getSports() {
		return sports;
	}
	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}
	public Set<String> getUserIds() {
		return userIds;
	}
	public void setUserIds(Set<String> userIds) {
		this.userIds = userIds;
	}
	public Set<String> getActivityIds() {
		return activityIds;
	}
	public void setActivityIds(Set<String> activityIds) {
		this.activityIds = activityIds;
	}  
}
