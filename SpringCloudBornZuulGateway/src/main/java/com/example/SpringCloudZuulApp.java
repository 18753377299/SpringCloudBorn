package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@ComponentScan(basePackages = "com")
@EnableCircuitBreaker//对hystrixR熔断机制的支持
public class SpringCloudZuulApp {
	
	public static void main(String[] args){
		SpringApplication.run(SpringCloudZuulApp.class, args);
	}
}
