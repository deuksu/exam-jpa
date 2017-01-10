package com.example.jdbc.service;

import java.util.List;

public interface JdbcService {

	public List<String> findByName(String name) throws Exception;
	public List<String> findAll(String name) throws Exception;
	public void save(String... args) throws Exception;
}
