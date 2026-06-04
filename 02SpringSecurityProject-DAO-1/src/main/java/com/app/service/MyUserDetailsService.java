package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.entity.Users;
import com.app.repo.IUserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired	
	private IUserRepo repo;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Users users = repo.findByName(username);
		
		if(users == null ) {
			throw new UsernameNotFoundException("User Not Found (404)");
		} 
		return new UserInformation(users);
	}
}
