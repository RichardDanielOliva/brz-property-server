package com.brz.commons.models.filter;

import com.brz.commons.models.filter.features.FeatureOfficesFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OfficeFilter extends PropertyFilter  {
	FeatureOfficesFilter features;
	
	public OfficeFilter() {}
	
	public FeatureOfficesFilter getFeatures() {
		return features;
	}

	public void setFeatures(FeatureOfficesFilter features) {
		this.features = features;
	}

}
