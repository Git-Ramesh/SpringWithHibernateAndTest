package com.rs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.rs.service","com.rs.dao"})
public class RootConfig {
	public RootConfig() {
		System.out.println("RootConfig: 0-param constr");
	}

}