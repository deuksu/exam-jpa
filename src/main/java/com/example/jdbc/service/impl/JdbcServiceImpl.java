package com.example.jdbc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.example.jdbc.service.JdbcService;

@Service
public class JdbcServiceImpl implements JdbcService {
	
	private static Logger logger = LoggerFactory.getLogger(JdbcServiceImpl.class);
	
	@Inject JdbcTemplate jdbcTemplate;
	
	@Override
	public List<String> findByName(String name) throws Exception {
		return this.findAll(name);
	}

	@Override
	public List<String> findAll(String name) throws Exception {
		List<String> rtn = new ArrayList<String>();
		SqlRowSet rs = null;
		
		if(name==null||name.isEmpty()) {
			rs = jdbcTemplate.queryForRowSet("SELECT * FROM MEMBER");	
		} else {
			rs = jdbcTemplate.queryForRowSet("SELECT * FROM MEMBER where NAME = ?", name);
		}
		
		while(rs!=null && rs.next()) {
			rtn.add(rs.getString("NAME"));
		}
		return rtn;
	}

	@Override
	public void save(String... args) throws Exception {
		jdbcTemplate.update("UPDATE MEMBER SET NAME = ? WHERE NAME = ?", args[1], args[0]);
	}
}
