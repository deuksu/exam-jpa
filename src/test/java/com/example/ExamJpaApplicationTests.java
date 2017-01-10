package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpa.domain.Account;
import com.example.jpa.repository.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamJpaApplicationTests {

	@Autowired AccountRepository accountRepository; 
	
	@Test
	public void test() {
		Account account = accountRepository.findByUserId("admin");
		System.out.println(account);
	}

}
