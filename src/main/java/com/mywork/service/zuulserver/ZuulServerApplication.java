package com.mywork.service.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.web.ZuulController;

@EnableZuulProxy
@SpringBootApplication
public class ZuulServerApplication   extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ZuulServerApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}
}
