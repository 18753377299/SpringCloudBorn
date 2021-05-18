package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
//因为缺少DataSource配置文件，则防止此类自动注入
//@EnableAutoConfiguration
//(exclude= {DataSourceAutoConfiguration.class})
//@ComponentScan主要就是定义扫描的路径从中找出标识了需要装配的类自动装配到spring的bean容器中
//@ComponentScan(basePackages="com.example")
@MapperScan({"com.example.**.dao"})
public class LeaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeaveApplication.class, args);
    }

}
