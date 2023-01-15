package com.example.demo.roleBaseAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.customerRepository.UserRepository;
import com.example.demo.entities.Roles;
import com.example.demo.entities.User;

public class CustomeUserDetailsServiceImple implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User findByUserName = userRepository.findByUsername(username);
		
		if(findByUserName==null) {
			throw new UsernameNotFoundException("Could not found user with this username "+username);
		}
		Roles findByUsername;
		CustomeUserDetails customeUserDetails = new CustomeUserDetails (findByUserName);
		return customeUserDetails;
	}

}
