package com.ccj.homework.homeworktest2.other.handlerinterceptoradapterconf;

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

        // 将各个拦截器注册为Bean
        @Bean
        public HandlerInterceptor smsHandlerInterceptorAdapter() {
                return new SmsHandlerInterceptorAdapter();
        }

        @Bean
        public HandlerInterceptor imageHandlerInterceptorAdapter() {
                return new ImageHandlerInterceptorAdapter();
        }

        @Bean
        public HandlerInterceptor resourcesHandlerInterceptorAdapter() {
                return new ResourcesHandlerInterceptorAdapter();
        }

        // 添加拦截器链并为每个拦截器配置拦截路径
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
                // addPathPatterns 用于添加拦截规则
                // excludePathPatterns 用于排除拦截
                registry.addInterceptor(smsHandlerInterceptorAdapter()).addPathPatterns("/login/phone-num");
                registry.addInterceptor(imageHandlerInterceptorAdapter()).addPathPatterns("/code/sms", "/pwd/alter");
                registry.addInterceptor(resourcesHandlerInterceptorAdapter()).addPathPatterns("/other", "/pwd/alter");
        }
}
