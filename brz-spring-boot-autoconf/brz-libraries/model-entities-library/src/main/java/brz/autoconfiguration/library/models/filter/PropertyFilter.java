package brz.autoconfiguration.library.models.filter;

import java.util.List;

import brz.autoconfiguration.library.models.entities.property.Operation;
import brz.autoconfiguration.library.models.entities.property.PropertyType;
import brz.autoconfiguration.library.models.entities.property.State;
import brz.autoconfiguration.library.models.entities.util.Page;
import brz.autoconfiguration.library.models.entities.util.Sorted;

public class PropertyFilter {
	private PropertyType type;
	private Operation operation;
	private Price price;
	private Area area;
	private List<State> status;
	private Location location;
    private Page page;
	private Sorted sortBy;
	
	public PropertyType getType() {
		return type;
	}
	public void setType(PropertyType type) {
		this.type = type;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public List<State> getStatus() {
		return status;
	}
	public void setStatus(List<State> status) {
		this.status = status;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Sorted getSortBy() {
		return sortBy;
	}
	public void setSortBy(Sorted sortBy) {
		this.sortBy = sortBy;
	}
	
	
	
	
}
