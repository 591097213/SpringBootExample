package com.ccj.homework.homeworktest2.other.staticdata;

import java.util.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;


/**
 * 用于读取YML文件中配置的URL
 */
@Component
@ConfigurationProperties(prefix = "interceptor-pathpatterns")
@Data
public class InterceptorPathpatterns {

    private List<String> authorizationInterceptorAdapter = new ArrayList<String>();
    private List<String> imageHandlerInterceptorAdapter = new ArrayList<String>();
    private List<String> resourcesHandlerInterceptorAdapter = new ArrayList<String>();
    private List<String> smsHandlerInterceptorAdapter = new ArrayList<String>();
    private List<String> tokenHandlerInterceptorAdapter = new ArrayList<String>();

}
