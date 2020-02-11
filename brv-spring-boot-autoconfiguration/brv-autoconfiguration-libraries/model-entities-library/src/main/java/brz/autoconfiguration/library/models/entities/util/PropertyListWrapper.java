package brz.autoconfiguration.library.models.entities.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PropertyListWrapper {

    @JsonProperty("_embedded")
    private PropertyList<?> embeddedHomes;
    private Page page;
    
    public PropertyListWrapper(PropertyList<?> embeddedHomes) {
    	this.embeddedHomes = embeddedHomes;
    }
    
    public PropertyListWrapper(PropertyList<?> embeddedHomes, Page page) {
    	this.embeddedHomes = embeddedHomes;
    	this.page = page;
    }

	public PropertyList<?> getEmbeddedHomes() {
		return embeddedHomes;
	}

	public void setEmbeddedHomes(PropertyList<?> embeddedHomes) {
		this.embeddedHomes = embeddedHomes;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}


	public PropertyListWrapper() {}
}
