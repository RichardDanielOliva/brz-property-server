package brz.autoconfiguration.library.models.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import brz.autoconfiguration.library.models.filter.features.FeatureOfficesFilter;

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
