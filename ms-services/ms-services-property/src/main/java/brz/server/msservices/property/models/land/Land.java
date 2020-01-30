package brz.server.msservices.property.models.land;

import com.brz.commons.models.entities.property.Property;

public class Land extends Property{
    private String id;
	private MainLandUse mainUse;
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
