package brz.autoconfiguration.library.models.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import brz.autoconfiguration.library.models.filter.features.FeaturePremiseFilter;

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
