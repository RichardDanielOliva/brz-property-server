package brz.server.msmodel.home.Controller;

import com.brz.commons.models.entities.util.Page;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HomeListWrapper {

    @JsonProperty("_embedded")
    private HomeList embeddedHomes;
    private Page page;
    
    public HomeListWrapper(HomeList embeddedHomes) {
    	this.embeddedHomes = embeddedHomes;
    }

	public HomeList getEmbeddedHomes() {
		return embeddedHomes;
	}

	public void setEmbeddedHomes(HomeList embeddedHomes) {
		this.embeddedHomes = embeddedHomes;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}


	public HomeListWrapper() {}
}
