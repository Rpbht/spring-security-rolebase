package com.cignex.rahul.springsecurityrolebase.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cignex.rahul.springsecurityrolebase.model.Role;
import com.cignex.rahul.springsecurityrolebase.model.User;


@Service
public class UserDetailService implements UserDetailsService{
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userService.findUserByEmail(email);
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : user.getRole()) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

}
