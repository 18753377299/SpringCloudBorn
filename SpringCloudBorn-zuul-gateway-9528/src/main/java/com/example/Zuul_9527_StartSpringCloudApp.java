package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.common.filter.ErrorZuulFilter;
import com.example.common.filter.PostZuulFilter;
import com.example.common.filter.PreZuulFilter;
import com.example.common.filter.RouteZuulFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableAutoConfiguration
@ComponentScan(basePackages = "com")
public class Zuul_9527_StartSpringCloudApp{
	
	public static void main(String[] args){
		SpringApplication.run(Zuul_9527_StartSpringCloudApp.class, args);
	}
	
	/*将PreZuulFilter加入到请求拦截队列*/
	@Bean
	public PreZuulFilter preZuulFilter() {  
	    return new PreZuulFilter();  
	} 
	@Bean
	public ErrorZuulFilter errorZuulFilter() {  
	    return new ErrorZuulFilter();  
	}  
	@Bean
	public PostZuulFilter postZuulFilter() {  
	    return new PostZuulFilter();  
	} 
	@Bean
	public RouteZuulFilter routeZuulFilter() {  
	    return new RouteZuulFilter();  
	}  
	
}
