package edu.hunau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //作为eureka注册中心使用
public class App2 {
    public static void main(String[] args) {
        SpringApplication.run(App2.class,args);
    }
}
