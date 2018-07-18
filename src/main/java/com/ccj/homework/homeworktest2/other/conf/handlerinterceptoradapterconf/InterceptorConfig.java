package com.ccj.homework.homeworktest2.other.conf.handlerinterceptoradapterconf;

import com.ccj.homework.homeworktest2.handlerinterceptoradapter.AuthorizationInterceptorAdapter;
import com.ccj.homework.homeworktest2.handlerinterceptoradapter.ImageHandlerInterceptorAdapter;
import com.ccj.homework.homeworktest2.handlerinterceptoradapter.ResourcesHandlerInterceptorAdapter;
import com.ccj.homework.homeworktest2.handlerinterceptoradapter.SmsHandlerInterceptorAdapter;
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
        AuthorizationInterceptorAdapter authorizationInterceptorAdapter;

        // 添加拦截器链并为每个拦截器配置拦截路径
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
                // addPathPatterns 用于添加拦截规则
                // excludePathPatterns 用于排除拦截
                registry.addInterceptor(this.authorizationInterceptorAdapter)
                                .addPathPatterns("/authorization/**", "/code/**");
                registry.addInterceptor(this.smsHandlerInterceptorAdapter)
                                .addPathPatterns("/authorization/phoneNum");
                registry.addInterceptor(this.imageHandlerInterceptorAdapter)
                                .addPathPatterns("/code/sms", "/pwd/alter");
                registry.addInterceptor(this.resourcesHandlerInterceptorAdapter)
                                .addPathPatterns("/other", "/pwd/alter");

        }
}
