package brz.autoconfiguration.autoconfigure.documentation;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("brz.documentation.api")
public class BrzSwaggerAPIDocumentationProperties {
	private String basePackage = "";
	private String title= "brz API Documentation";
	private String description= "brz server";
	private String version= "1.0";
	private String termsOfServiceUrl= "Terms of Service: brz";
	private String license= "Apache License Version 2.0";
	private String licenseUrl= "https://www.apache.org/licenses/LICENSE-2.0";
	
	public String getBasePackage() {
		return basePackage;
	}
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTermsOfServiceUrl() {
		return termsOfServiceUrl;
	}
	public void setTermsOfServiceUrl(String termsOfServiceUrl) {
		this.termsOfServiceUrl = termsOfServiceUrl;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getLicenseUrl() {
		return licenseUrl;
	}
	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	
}
