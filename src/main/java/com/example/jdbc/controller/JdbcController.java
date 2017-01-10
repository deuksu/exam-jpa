package com.example.jdbc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jdbc.service.JdbcService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/jdbc")
public class JdbcController {

	private static final Logger logger = LoggerFactory.getLogger(JdbcController.class);
	
	@RequestMapping("/")
	public @ResponseBody String filtering(@RequestParam(value="t", required=true) String cont) {
		return cont;
	}	
	
	@Autowired JdbcService jdbcService;
	
	@ResponseBody
	@RequestMapping("/find")
	public String findByName(@RequestParam(value="name", required=false) String name) throws Exception {
		List<String> custList = jdbcService.findByName(name);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(custList);
	}
	
	@ResponseBody
	@RequestMapping("/save")
	public String save(@RequestParam(value="o", required=true) String oldName,@RequestParam(value="n", required=true) String newName) throws Exception {
		jdbcService.save(oldName,newName);
		return "success";
	}
}
