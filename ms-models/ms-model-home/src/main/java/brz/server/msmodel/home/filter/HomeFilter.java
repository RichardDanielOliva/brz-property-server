package brz.server.msmodel.home.filter;

import com.brz.commons.models.filter.PropertyFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HomeFilter extends PropertyFilter {
	FeatureHomeFilter features;

	public FeatureHomeFilter getFeatures() {
		return features;
	}

	public void setFeatures(FeatureHomeFilter features) {
		this.features = features;
	}

	@Override
	public String toString() {
		return "HomeFilter [features=" + features + ", getType()=" + getType() + ", getOperation()=" + getOperation()
				+ ", getPrice()=" + getPrice() + ", getArea()=" + getArea() + ", getStatus()=" + getStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
