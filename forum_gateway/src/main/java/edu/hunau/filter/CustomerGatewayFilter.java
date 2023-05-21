package edu.hunau.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class CustomerGatewayFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //此处实现自定义过滤规则 ，可以通过return来决定是否继续访问
        System.out.println("my gateway filter work........");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {//过滤器排序方法
        return 0;
    }
}
