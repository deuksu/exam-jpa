package com.example.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jpa.domain.Account;
import com.example.jpa.domain.SecurityUser;
import com.example.jpa.repository.AccountRepository;
import com.example.jpa.service.SecurityUserDetailsService;

@Service
public class SecurityUserDetailsServiceImpl implements UserDetailsService, SecurityUserDetailsService {

	@Autowired AccountRepository accountRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUserId(username);
		if(account==null)
			throw new UsernameNotFoundException(username);
		return new SecurityUser(account);
	}
}
