package edu.hunau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //作为Eureka客户端 微服务
public class PostManagerApp1 {
    public static void main(String[] args) {
        SpringApplication.run(PostManagerApp1.class,args);
    }
}
