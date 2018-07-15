package com.ccj.homework.homeworktest2.other.handlerinterceptoradapterconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.ccj.homework.homeworktest2.handlerinterceptoradapter.*;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

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

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
                // addPathPatterns 用于添加拦截规则
                // excludePathPatterns 用于排除拦截
                // MyHandlerInterceptor1()为自己定义的拦截器
                registry.addInterceptor(smsHandlerInterceptorAdapter())
                                .addPathPatterns("/login/phone-num");
                registry.addInterceptor(imageHandlerInterceptorAdapter())
                                .addPathPatterns("/code/sms", "/pwd/alter");
                registry.addInterceptor(resourcesHandlerInterceptorAdapter())
                                .addPathPatterns("/other", "/pwd/alter");
        }
}
