package edu.hunau.config;

import edu.hunau.Interceptor.TokenInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截器配置
 *
 * @author ND_LJQ
 * @date 2022/12/17
 */
@Component
public class IntercepterConfig implements WebMvcConfigurer {
    private TokenInterceptor tokenInterceptor;

    /**
     * 拦截器配置
     *
     * @param tokenInterceptor 令牌拦截器
     */
    public IntercepterConfig(TokenInterceptor tokenInterceptor){
        this.tokenInterceptor = tokenInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        List<String> excludePath = new ArrayList<>();

        excludePath.add("/**/forumpost/article/*");
        excludePath.add("/**/forumpost/article/user/*");
        excludePath.add("/**/forumpost/postings");
        excludePath.add("/**/forumpost/movearticle/*");

        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
        //除了登陆接口其他所有接口都需要token验证
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
