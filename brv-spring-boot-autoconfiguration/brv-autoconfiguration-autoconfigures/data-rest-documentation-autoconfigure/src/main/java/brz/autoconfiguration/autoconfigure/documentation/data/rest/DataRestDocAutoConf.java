package brz.autoconfiguration.autoconfigure.documentation.data.rest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


import org.springframework.boot.context.properties.EnableConfigurationProperties;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;


@Configuration
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
@ConditionalOnProperty(name="brz.documentation.data.rest.enable")
@EnableConfigurationProperties({DataRestAPIProperties.class, DeveloperDataRestProp.class})
public class DataRestDocAutoConf {
	@Autowired
	DataRestAPIProperties apiProperties;
	
	@Autowired
	DeveloperDataRestProp developerProperties;
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_12)  
          .select()                 
          .apis(RequestHandlerSelectors.any())               
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(metaData());                                           
    }
    
    private ApiInfo metaData(){
        return new ApiInfo(
        		apiProperties.getTitle(),
        		apiProperties.getDescription(),
        		apiProperties.getVersion(),
        		apiProperties.getTermsOfServiceUrl(),
                contactInfo(),
                apiProperties.getLicense(),
                apiProperties.getLicenseUrl(),
                new ArrayList<>());
    }
    
    private Contact contactInfo() {
    	return new Contact(developerProperties.getName(), 
    			developerProperties.getUrl(), 
    			developerProperties.getEmail());
    }
}
