package com.ccj.homework.homeworktest2.other.handlerinterceptoradapterconf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.ccj.homework.homeworktest2.handlerinterceptoradapter.*;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用于排除拦截
        // MyHandlerInterceptor1()为自己定义的拦截器
        registry.addInterceptor(new SmsHandlerInterceptorAdapter()).addPathPatterns("/login/phone-num");
        registry.addInterceptor(new ImageHandlerInterceptorAdapter()).addPathPatterns("/code/sms");
        registry.addInterceptor(new ResourcesHandlerInterceptorAdapter()).addPathPatterns("/other/**");
    }
}