package edu.hunau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient  //作为Eureka客户端 微服务
@SpringBootApplication
public class UserManagerApp1 {
    public static void main(String[] args) {
        SpringApplication.run(UserManagerApp1.class,args);
    }
}
