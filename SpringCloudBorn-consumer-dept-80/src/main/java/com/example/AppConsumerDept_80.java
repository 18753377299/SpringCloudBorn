package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.myrule.MySelfRule;

/**
 * Hello world!
 *  @RibbonClient  这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下，
 *  否则我们自定义的这个配置类就会被所有的ribbon客户端所共享，也就是说我们达不到特殊化定制的目的了。
 */
@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
//@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
@RibbonClient(name="SpringCloudBorn-dept",configuration=MySelfRule.class)
public class AppConsumerDept_80 {
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        SpringApplication.run(AppConsumerDept_80.class, args);
    }
}
