package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	public Account findByUserId(String userId);
	public Account findByNick(String nick);
}
