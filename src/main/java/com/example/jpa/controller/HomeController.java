package com.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.jpa.domain.Account;
import com.example.jpa.domain.SecurityUser;
import com.example.jpa.repository.AccountRepository;

@Controller
@RequestMapping("/jpa")
public class HomeController {
	
	@RequestMapping("")
	public String index() {return "/jpa/index";}
	
	@RequestMapping("/admin")
	public void admin() {}
	
	@RequestMapping("/user")
	public void user() {}
	
	@RequestMapping("/login")
	public void login() {}
	
	
	@RequestMapping("/registerForm")
	public void registerForm() {}
	
	
	// 필요한 부분은 Serivce계층으로 옮겨줘야 합니다. 
	@Autowired AccountRepository accountRepository;
	@Autowired PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(Account account){
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		accountRepository.save(account);
		
		// SecurityContextHolder에서 Context를 받아 인증 설정
		SecurityUser user = new SecurityUser(account);
		Authentication authentication = 
				new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/jpa";
	}
}
