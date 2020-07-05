package brz.autoconfiguration.library.models.entities.property;

import java.util.List;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import brz.autoconfiguration.library.models.entities.util.GeoJsonPointSerializer;
import brz.autoconfiguration.library.models.entities.util.GeoJsonPointDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Property {
	@Field("cadastral_reference")
	private String cadastralReference;
	private float area;
	private Location location;
	private Advertiser advertiser;
	private List<String> images;
	
	@JsonSerialize(using = GeoJsonPointSerializer.class)
	//@JsonDeserialize(contentUsing = GeoJsonPointDeserializer.class)
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE,name = "geometry_index")
	private GeoJsonPoint geometry;
	
	public String getCadastralReference() {
		return cadastralReference;
	}
	public void setCadastralReference(String cadastralReference) {
		this.cadastralReference = cadastralReference;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Advertiser getAdvertiser() {
		return advertiser;
	}
	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public GeoJsonPoint getGeometry() {
		return geometry;
	}
	public void setGeometry(GeoJsonPoint geometry) {
		this.geometry = geometry;
	}

	
	
}
