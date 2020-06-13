package com.brz.commons.models.filter.features;

import java.util.List;

import com.brz.commons.models.entities.premise.Extra;
import com.brz.commons.models.entities.premise.Type;

public class FeaturePremiseFilter {
	private List<Type> types;
	private List<Extra> extras;
	
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	public List<Extra> getExtras() {
		return extras;
	}
	public void setExtras(List<Extra> extras) {
		this.extras = extras;
	}


	
}
