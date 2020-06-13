package com.brv.security.services;

import com.brz.commons.models.entities.user.User;

public interface UserServices {
	
	public User findByUsername(String username);
	
	public User update(User usuario, Long id);

}
