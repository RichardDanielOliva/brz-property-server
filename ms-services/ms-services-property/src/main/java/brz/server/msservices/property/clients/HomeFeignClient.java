package brz.server.msservices.property.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import brz.server.msservices.property.models.home.Home;
import brz.server.msservices.property.models.home.HomeListWrapper;

@FeignClient(name = "ms-model-home")
public interface HomeFeignClient {
	
	@GetMapping("/homes")
	public HomeListWrapper findAll();

}

