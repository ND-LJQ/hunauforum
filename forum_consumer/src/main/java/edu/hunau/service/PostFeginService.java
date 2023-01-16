package edu.hunau.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author ND_LJQ
 * @date 2022/12/22
 */// Feign远程调用客户端
@FeignClient(value = "postManager") //需要访问的远程微服务应用名称
public interface PostFeginService {

    public String getArticleInfo();
}
