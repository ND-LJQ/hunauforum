package edu.hunau.config;

import edu.hunau.Interceptor.CorsInterceptor;
import edu.hunau.Interceptor.TokenInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author ND_LJQ
 * @date 2022/12/17
 */
@Component
public class IntercepterConfig implements WebMvcConfigurer {
    private TokenInterceptor tokenInterceptor;

    private CorsInterceptor corsInterceptor;

    //构造方法
    public IntercepterConfig(TokenInterceptor tokenInterceptor,CorsInterceptor corsInterceptor){
        this.tokenInterceptor = tokenInterceptor;
        this.corsInterceptor = corsInterceptor;
    }


//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        List<String> excludePath = new ArrayList<>();
//        //登录
//        excludePath.add("/**/forumuser/test");
//        excludePath.add("/**/forumuser/login/*");
//        excludePath.add("/**/forumuser/login/email");;
//        excludePath.add("/**/forumuser/register/*");
//        excludePath.add("/**/forumuser/changepwd/");
//        excludePath.add("/**/forumuser/user/*");
//        excludePath.add("/**/forumuser/changeinfo");
//       // 跨域拦截器
//
//        registry.addInterceptor(corsInterceptor)
//                .addPathPatterns("/**");
//
//        registry.addInterceptor(tokenInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns(excludePath);
//        //除了登陆接口其他所有接口都需要token验证
//        WebMvcConfigurer.super.addInterceptors(registry);
//
//    }

}
