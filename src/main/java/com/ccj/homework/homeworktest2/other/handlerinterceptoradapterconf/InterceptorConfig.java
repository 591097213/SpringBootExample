package com.ccj.homework.homeworktest2.other.handlerinterceptoradapterconf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.ccj.homework.homeworktest2.handlerinterceptoradapter.*;

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

        // 添加拦截器链并为每个拦截器配置拦截路径
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
                // addPathPatterns 用于添加拦截规则
                // excludePathPatterns 用于排除拦截
                registry.addInterceptor(smsHandlerInterceptorAdapter)
                                .addPathPatterns("/login/phone-num");
                registry.addInterceptor(imageHandlerInterceptorAdapter).addPathPatterns("/code/sms",
                                "/pwd/alter");
                registry.addInterceptor(this.resourcesHandlerInterceptorAdapter)
                                .addPathPatterns("/other", "/pwd/alter");
        }
}
