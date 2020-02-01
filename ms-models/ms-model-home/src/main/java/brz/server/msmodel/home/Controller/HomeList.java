package brz.server.msmodel.home.Controller;

import java.util.ArrayList;
import java.util.List;

import brz.server.msmodel.home.persistence.entities.Home;

public class HomeList {
    private List<Home> homes;
    
	public HomeList() {
		setHomes(new ArrayList<>());
	}
	
	public HomeList(List<Home> homes) {
		this.homes = homes;
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
