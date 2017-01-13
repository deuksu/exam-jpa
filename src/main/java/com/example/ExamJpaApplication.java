package com.example;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.jpa.domain.Account;
import com.example.jpa.domain.Member;
import com.example.jpa.repository.AccountRepository;
import com.example.jpa.repository.MemberRepository;

//@EntityScan(basePackages="com.example.domain")
//@EnableJpaRepositories(basePackages="com.example.repository") 자동으로 springbootapplication에서 사용되고 있음
@SpringBootApplication
public class ExamJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamJpaApplication.class, args);
	}
	
	@Autowired MemberRepository memberRepository;
	@Autowired AccountRepository accountRepository;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CommandLineRunner runner() {
		return (a)->{
			memberRepository.save(new Member("a", 10));
			memberRepository.save(new Member("b", 15));
			memberRepository.save(new Member("c", 10));
			memberRepository.save(new Member("a", 5));
			
			memberRepository.findAll().forEach(System.out::println);
		};
	}
	
    @Bean
    public InitializingBean insertFixtureUsers(){
		return ()->{
			Account admin = new Account();
			admin.setUserId("admin");
			admin.setPassword(passwordEncoder().encode("1234"));
			admin.setRole("ROLE_ADMIN");
			admin.setNick("어드민");
			accountRepository.save(admin);
			
			Account user = new Account();
			user.setUserId("user");
			user.setPassword(passwordEncoder().encode("1234"));
			user.setRole("ROLE_USER");
			user.setNick("사용자");
			accountRepository.save(user);
			
			accountRepository.findAll().forEach(System.out::println);
		};
	}	
}
