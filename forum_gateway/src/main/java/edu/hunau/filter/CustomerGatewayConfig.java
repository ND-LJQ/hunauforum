package edu.hunau.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerGatewayConfig {
    //将工厂类配置成spring容器内的对象
    @Bean
    public CustomerGatewayFilterFactory getCustomerGatewayFilterFactory(){
        return new CustomerGatewayFilterFactory();
    }
}
