package com.example.main;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.domain.Account;
import com.example.jpa.repository.AccountRepository;

@RestController
@RequestMapping("/rest")
public class RestMainController {

	@RequestMapping("/list")
	public List<Integer> list() {
		return Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	}	
	
	@Autowired AccountRepository accountRepository;
	
	@RequestMapping("/domain")
	public Account domain(@RequestParam(name="nick", required=true) String nick) {
		return accountRepository.findByNick(nick);
	}		
}
