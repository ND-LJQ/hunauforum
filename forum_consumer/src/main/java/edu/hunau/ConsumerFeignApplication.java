package edu.hunau;

import edu.hunau.config.LoadBalancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 消费者装应用程序
 * 主配置类单独处理 负载均衡配置类 ，有多个Provider都需要配置，同名配置一个即可
 * @author ND_LJQ
 * @date 2022/12/22
 */
@LoadBalancerClients(value = {
        @LoadBalancerClient(name = "postManager",configuration = LoadBalancerConfig.class),
        @LoadBalancerClient(name = "userManager",configuration = LoadBalancerConfig.class)
})

@SpringBootApplication
@EnableFeignClients
public class ConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication.class,args);
    }
}
