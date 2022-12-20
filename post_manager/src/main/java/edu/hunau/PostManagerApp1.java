package edu.hunau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 发布管理
 *
 * @author ND_LJQ
 * @date 2022/12/20
 */
@SpringBootApplication
@EnableEurekaClient
public class PostManagerApp1 {
    public static void main(String[] args) {
        SpringApplication.run(PostManagerApp1.class,args);
    }
}
