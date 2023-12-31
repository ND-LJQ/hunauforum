package edu.hunau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ND_LJQ
 */
@EnableEurekaClient
@SpringBootApplication
public class ChatApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ChatApplication.class,args);
    }
}
