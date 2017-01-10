package com.example.jpa.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {
	
	private static final long serialVersionUID = 1L;
	
	private Account account;
	
	public SecurityUser(Account account) {
		super(account.getUserId(), account.getPassword(), authorities(account));
		this.account = account;
	}

	private static Collection<? extends GrantedAuthority> authorities(Account account) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		//user:role = 1:n
		authorities.add(new SimpleGrantedAuthority(account.getRole()));
		return authorities;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getNick() {
		return account.getNick();
	}

	@Override
	public String toString() {
		return "SecurityUser [account=" + account + "]";
	}
	
}
