package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient  // 本服务启动后会自动注入到eureka中
@EnableDiscoveryClient   // 服务发现
@EnableCircuitBreaker//对hystrixR熔断机制的支持
public class AppProviderHystrixDept_8001 {
	
    public static void main(String[] args){
    	
		SpringApplication.run(AppProviderHystrixDept_8001.class, args);
		
	}
}
