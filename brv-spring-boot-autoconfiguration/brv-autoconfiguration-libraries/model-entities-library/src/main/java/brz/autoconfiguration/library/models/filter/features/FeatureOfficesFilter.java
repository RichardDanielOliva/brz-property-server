package brz.autoconfiguration.library.models.filter.features;

import java.util.List;

import brz.autoconfiguration.library.models.entities.office.Extra;

public class FeatureOfficesFilter {
	private List<Extra> extras;

	public FeatureOfficesFilter() {}

	public List<Extra> getExtras() {
		return extras;
	}
	public void setExtras(List<Extra> extras) {
		this.extras = extras;
	}

}
