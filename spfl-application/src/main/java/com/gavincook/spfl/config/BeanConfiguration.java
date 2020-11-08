package com.gavincook.spfl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class BeanConfiguration {

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}
