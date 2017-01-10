package com.example.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpa.domain.Account;
import com.example.jpa.repository.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SecurityUserDetailsServiceImplTest {
	
	@Autowired AccountRepository accountRepository; 
	
	@Test
	public void testLoadUserByUsername() {
		Account account = accountRepository.findByUserId("admin");
		System.out.println(account);
	}

}
