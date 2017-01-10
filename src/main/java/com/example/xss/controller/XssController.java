package com.example.xss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/xss")
public class XssController {

	@RequestMapping("/")
	public @ResponseBody String filtering(@RequestParam(value="t", required=true) String cont) {
		return cont;
	}
	
}