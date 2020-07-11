package com.brz.commons.models.filter;

import com.brz.commons.models.filter.features.FeaturePremiseFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PremiseFilter extends PropertyFilter  {
	FeaturePremiseFilter features;
	
	public PremiseFilter() {}
	
	public FeaturePremiseFilter getFeatures() {
		return features;
	}

	public void setFeatures(FeaturePremiseFilter features) {
		this.features = features;
	}

}
