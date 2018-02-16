package com.rs.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.rs.config.RootConfig;
import com.rs.config.WebMvcConfig;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	public Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		return new Class[] {WebMvcConfig.class};
	}

	@Override
	public String[] getServletMappings() {
		return new String[] {"*.htm"};
	}

}
