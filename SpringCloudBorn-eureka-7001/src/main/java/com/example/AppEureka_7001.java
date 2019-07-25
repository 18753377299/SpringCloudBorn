package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEureka_7001 
{
    public static void main( String[] args )
    {
       SpringApplication.run(AppEureka_7001.class, args);
    }
}

