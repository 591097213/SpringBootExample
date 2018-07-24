package com.ccj.homework.homeworktest2.other.conf.handlerinterceptoradapterconf;

import com.ccj.homework.homeworktest2.handlerinterceptoradapter.AuthorizationHandlerInterceptorAdapter;
import com.ccj.homework.homeworktest2.handlerinterceptoradapter.ImageHandlerInterceptorAdapter;
import com.ccj.homework.homeworktest2.handlerinterceptoradapter.ResourcesHandlerInterceptorAdapter;
import com.ccj.homework.homeworktest2.handlerinterceptoradapter.SmsHandlerInterceptorAdapter;
import com.ccj.homework.homeworktest2.handlerinterceptoradapter.TokenHandlerInterceptorAdapter;
import com.ccj.homework.homeworktest2.other.staticdata.InterceptorPathpatterns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

        @Autowired
        ImageHandlerInterceptorAdapter imageHandlerInterceptorAdapter;

        @Autowired
        SmsHandlerInterceptorAdapter smsHandlerInterceptorAdapter;

        @Autowired
        ResourcesHandlerInterceptorAdapter resourcesHandlerInterceptorAdapter;

        @Autowired
        AuthorizationHandlerInterceptorAdapter authorizationHandlerInterceptorAdapter;

        @Autowired
        TokenHandlerInterceptorAdapter tokenHandlerInterceptorAdapter;

        // 注入YML文件中配置的URL
        @Autowired
        InterceptorPathpatterns interceptorPathpatterns;

        // 添加拦截器链并为每个拦截器配置拦截路径
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
                // addPathPatterns 用于添加拦截规则
                // excludePathPatterns 用于排除拦截
                registry.addInterceptor(this.authorizationHandlerInterceptorAdapter)
                                .addPathPatterns(interceptorPathpatterns
                                                .getAuthorizationInterceptorAdapter());
                registry.addInterceptor(this.smsHandlerInterceptorAdapter).addPathPatterns(
                                interceptorPathpatterns.getSmsHandlerInterceptorAdapter());
                registry.addInterceptor(this.imageHandlerInterceptorAdapter).addPathPatterns(
                                interceptorPathpatterns.getImageHandlerInterceptorAdapter());
                registry.addInterceptor(this.resourcesHandlerInterceptorAdapter).addPathPatterns(
                                interceptorPathpatterns.getResourcesHandlerInterceptorAdapter());
                registry.addInterceptor(this.tokenHandlerInterceptorAdapter).addPathPatterns(
                                interceptorPathpatterns.getTokenHandlerInterceptorAdapter());

        }
}
