package edu.hunau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 搜索引擎应用程序
 *
 * @author ND_LJQ
 * @date 2023/04/22
 */

@SpringBootApplication
@EnableEurekaClient
public class SearchEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchEngineApplication.class,args);
    }
}
