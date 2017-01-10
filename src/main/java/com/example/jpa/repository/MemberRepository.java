package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.jpa.domain.Member;

public interface MemberRepository extends CrudRepository<Member,Long> {
	
	List<Member> findByNameAndAgeLessThan(String name, int age);
	
	@Query("select t from Member t where name=:name and age < :age")
	List<Member> findByNameAndAgeLessThanSQL(@Param("name") String name, @Param("age") int age);
	
	List<Member> findByNameAndAgeLessThanOrderByAgeDesc(String name, int age);
}
