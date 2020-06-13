package com.brv.security.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brv.security.clients.UserFeignClient;
import com.brz.commons.models.entities.user.User;

import feign.FeignException;

@Service
public class UsuarioServiceImpl implements UserServices, UserDetailsService {

	private Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UserFeignClient userClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			User user = userClient.findByUsername(username);

			List<GrantedAuthority> authorities = user.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
					.peek(authority -> log.info("Role: " + authority.getAuthority())).collect(Collectors.toList());

			return new org.springframework.security.core.userdetails
					.User(user.getUsername(), 
							user.getPassword(), 
							user.isEnabled(), 
							true, true, true,
							authorities);

		} catch (FeignException e) {
			String error = "Error en el login, no existe el usuario '" + username + "' en el sistema";
			log.error(error);

			throw new UsernameNotFoundException(error);
		}
	}


	@Override
	public User findByUsername(String username) {
		return userClient.findByUsername(username);
	}

	@Override
	public User update(User user,Long id) {
		return userClient.update(user, id);
	}

}
