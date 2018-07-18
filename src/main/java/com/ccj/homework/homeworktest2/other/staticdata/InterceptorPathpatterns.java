package com.ccj.homework.homeworktest2.other.staticdata;

import java.util.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 用于读取YML文件中配置的URL
 */
@Component
@ConfigurationProperties(prefix = "interceptor-pathpatterns")
public class InterceptorPathpatterns {

    private List<String> authorizationInterceptorAdapter = new ArrayList<String>();
    private List<String> imageHandlerInterceptorAdapter = new ArrayList<String>();
    private List<String> resourcesHandlerInterceptorAdapter = new ArrayList<String>();
    private List<String> smsHandlerInterceptorAdapter = new ArrayList<String>();


    /**
     * @return List<String> return the authorizationInterceptorAdapter
     */
    public List<String> getAuthorizationInterceptorAdapter() {
        return authorizationInterceptorAdapter;
    }

    /**
     * @param authorizationInterceptorAdapter the authorizationInterceptorAdapter to set
     */
    public void setAuthorizationInterceptorAdapter(List<String> authorizationInterceptorAdapter) {
        this.authorizationInterceptorAdapter = authorizationInterceptorAdapter;
    }

    /**
     * @return List<String> return the imageHandlerInterceptorAdapter
     */
    public List<String> getImageHandlerInterceptorAdapter() {
        return imageHandlerInterceptorAdapter;
    }

    /**
     * @param imageHandlerInterceptorAdapter the imageHandlerInterceptorAdapter to set
     */
    public void setImageHandlerInterceptorAdapter(List<String> imageHandlerInterceptorAdapter) {
        this.imageHandlerInterceptorAdapter = imageHandlerInterceptorAdapter;
    }

    /**
     * @return List<String> return the resourcesHandlerInterceptorAdapter
     */
    public List<String> getResourcesHandlerInterceptorAdapter() {
        return resourcesHandlerInterceptorAdapter;
    }

    /**
     * @param resourcesHandlerInterceptorAdapter the resourcesHandlerInterceptorAdapter to set
     */
    public void setResourcesHandlerInterceptorAdapter(
            List<String> resourcesHandlerInterceptorAdapter) {
        this.resourcesHandlerInterceptorAdapter = resourcesHandlerInterceptorAdapter;
    }

    /**
     * @return List<String> return the smsHandlerInterceptorAdapter
     */
    public List<String> getSmsHandlerInterceptorAdapter() {
        return smsHandlerInterceptorAdapter;
    }

    /**
     * @param smsHandlerInterceptorAdapter the smsHandlerInterceptorAdapter to set
     */
    public void setSmsHandlerInterceptorAdapter(List<String> smsHandlerInterceptorAdapter) {
        this.smsHandlerInterceptorAdapter = smsHandlerInterceptorAdapter;
    }



}
