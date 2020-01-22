package brz.server.msmodel.land.persistence.entities;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.brz.commons.models.entities.property.Property;

@Document(collection = "lands")
public class Land extends Property{
	@Id
    private String id;
	private MainLandUse mainLandUse;
	private ClassType classType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MainLandUse getMainLandUse() {
		return mainLandUse;
	}
	public void setMainLandUse(MainLandUse mainLandUse) {
		this.mainLandUse = mainLandUse;
	}
	public ClassType getClassType() {
		return classType;
	}
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
}
