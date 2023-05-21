package edu.hunau.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class KeyResolverConfig {

    //URL限流规则配置
    @Bean
    public KeyResolver pathKeyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                //return Mono.just(exchange.getRequest().getPath().toString());//URI限流
                return Mono.just(exchange.getRequest().getQueryParams().getFirst("name"));//参数限流(请求要包含name参数)
                //return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());//IP限流
            }
        };
    }
}
