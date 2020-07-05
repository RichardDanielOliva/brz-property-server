package brz.server.msservices.azurestoge.presentation.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import brz.server.msservices.azurestoge.business.AzureBlobServices;


@RefreshScope
@RestController
public class HomeController {		
    @Autowired
    private Environment environment;
    
    @Autowired
    private AzureBlobServices azureBlobServices;
    
    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam("files") List<MultipartFile> multipartFiles){
    	ArrayList<URI> urls = new ArrayList<URI>();
    	System.out.println(multipartFiles.size());
    	for (MultipartFile multipartFile : multipartFiles) {
    		URI url = azureBlobServices.upload(multipartFile);
    		System.out.println(url);
    		urls.add(url);
		}
        return ResponseEntity.ok(urls);
    }
    
	@GetMapping(path = "/",  produces = {MediaType.APPLICATION_JSON_VALUE})
	public String listar(){
		return environment.getProperty("azure.storage.ConnectionString");
	}
	
}
