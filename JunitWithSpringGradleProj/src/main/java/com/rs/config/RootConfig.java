package com.rs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"com.rs.service"})
@Import(value= {PersistenceConfig.class})
public class RootConfig {
	public RootConfig() {
		System.out.println("RootConfig: 0-param constr");
	}

}