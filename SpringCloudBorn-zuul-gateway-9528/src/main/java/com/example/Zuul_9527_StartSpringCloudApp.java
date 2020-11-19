package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableAutoConfiguration
@ComponentScan(basePackages = "com")
public class Zuul_9527_StartSpringCloudApp{
	
	public static void main(String[] args){
		SpringApplication.run(Zuul_9527_StartSpringCloudApp.class, args);
	}
	
}
