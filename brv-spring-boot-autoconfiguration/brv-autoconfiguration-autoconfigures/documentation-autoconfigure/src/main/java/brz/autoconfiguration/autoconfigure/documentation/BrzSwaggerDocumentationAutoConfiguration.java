package brz.autoconfiguration.autoconfigure.documentation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(name="brz.documentation.enable")
@EnableConfigurationProperties({BrzSwaggerAPIDocumentationProperties.class, BrzSwaggerContactDeveloperProperties.class})
public class BrzSwaggerDocumentationAutoConfiguration{       

	@Autowired
	BrzSwaggerAPIDocumentationProperties apiProperties;
	
	@Autowired
	BrzSwaggerContactDeveloperProperties developerProperties;
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage(apiProperties.getBasePackage()))              
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