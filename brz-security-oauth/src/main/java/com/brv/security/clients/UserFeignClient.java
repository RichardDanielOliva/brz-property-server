package com.brv.security.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.brz.commons.models.entities.user.User;


@FeignClient(name="ms-model-user")
public interface UserFeignClient {

	@GetMapping("/users/search/findByUsername")
	public User findByUsername(@RequestParam String username);
	
	@PutMapping("/users/{id}")
	public User update(@RequestBody User usuario, @PathVariable Long id);
}
