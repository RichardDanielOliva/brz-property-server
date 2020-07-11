package com.brz.commons.models.filter.features;

import java.util.List;

import com.brz.commons.models.entities.office.Extra;

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
