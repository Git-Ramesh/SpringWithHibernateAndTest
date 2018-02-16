package com.rs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages= "com.rs.controller")
@EnableWebMvc
public class WebMvcConfig {
	public WebMvcConfig() {
		System.out.println("WebMvcConfig: 0-param constr");
	}
	
	@Bean("viewResolver")
	public ViewResolver createInternalResourceViewResolver() {
		InternalResourceViewResolver viewResolver=null;
		
		viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
}