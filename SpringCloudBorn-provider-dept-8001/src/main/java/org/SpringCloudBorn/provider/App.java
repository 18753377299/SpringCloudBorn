package org.SpringCloudBorn.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class App {
    public static void main(String[] args){
    	
		SpringApplication.run(App.class, args);
		
	}
}
