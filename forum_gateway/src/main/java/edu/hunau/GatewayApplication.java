package edu.hunau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ND_LJQ
 */
@SpringBootApplication
@EnableDiscoveryClient  //作为Eureka客户端 微服务
public class GatewayApplication
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        SpringApplication.run(GatewayApplication.class,args);
    }
}
