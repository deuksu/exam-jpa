package com.example.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.common.filter.SimpleFilter;

@Configuration
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean(SimpleFilter filter) {
		FilterRegistrationBean bean = new FilterRegistrationBean(filter);
		bean.setOrder(1);
		return bean;
	}
}
