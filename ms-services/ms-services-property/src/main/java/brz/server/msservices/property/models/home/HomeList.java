package brz.server.msservices.property.models.home;

import java.util.ArrayList;
import java.util.List;

public class HomeList {
    private List<Home> homes;
    
	public HomeList() {
		setHomes(new ArrayList<>());
	}

	public List<Home> getHomes() {
		return homes;
	}

	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}

	@Override
	public String toString() {
		return "HomeList [homes=" + homes + "]";
	}

	
}
