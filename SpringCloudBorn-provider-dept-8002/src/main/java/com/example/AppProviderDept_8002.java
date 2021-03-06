package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient  // 本服务启动后会自动注入到eureka中
@EnableDiscoveryClient   // 服务发现
public class AppProviderDept_8002 {
    public static void main(String[] args){
    	
		SpringApplication.run(AppProviderDept_8002.class, args);
		
	}
}
