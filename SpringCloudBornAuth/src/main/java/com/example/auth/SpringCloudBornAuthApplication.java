package com.example.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**https://www.cnblogs.com/ll409546297/p/10396837.html
 * https://blog.csdn.net/nb7474/article/details/88696205
 * */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringCloudBornAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBornAuthApplication.class, args);
    }

}
