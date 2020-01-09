package brz.autoconfiguration.autoconfigure.documentation.data.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("brz.documentation.data.rest.developer")
public class DeveloperDataRestProp {
	private String name= "Beeto Developer";
	private String email= "example@beeto.com";
	private String url= "";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
