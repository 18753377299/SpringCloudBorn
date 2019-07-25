package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *  @RibbonClient  这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下，
 *  否则我们自定义的这个配置类就会被所有的ribbon客户端所共享，也就是说我们达不到特殊化定制的目的了。
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
@EnableFeignClients(basePackages= {"com.example"})
@ComponentScan("com.example")
public class AppConsumerDeptFeign 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(AppConsumerDeptFeign.class, args);
    }
}
