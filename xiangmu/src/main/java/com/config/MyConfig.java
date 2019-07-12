package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Component
@Slf4j
public class MyConfig  implements WebMvcConfigurer{
	  @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(new MyInterceptor())
	                .addPathPatterns("/**")
	                .excludePathPatterns("/add");
	    }

	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	        registry.addResourceHandler("/static/**")
//	                .addResourceLocations("classpath:/static1/");
	    	 registry.addResourceHandler("/upload/**").addResourceLocations("file:///"+"D:\\tt\\work\\Tomcat\\localhost\\ROOT\\upload\\");
	    	
	    }
	
}
