package brz.server.msmodel.land.persistence.entities;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.brz.commons.models.entities.property.Property;

@Document(collection = "lands")
public class Land extends Property{
	@Id
    private String id;
	@Field("main_use")
	private MainLandUse mainUse;
	@Field("class_type")
	private ClassType classType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MainLandUse getMainUse() {
		return mainUse;
	}
	public void setMainUse(MainLandUse mainLandUse) {
		this.mainUse = mainLandUse;
	}
	public ClassType getClassType() {
		return classType;
	}
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
}
