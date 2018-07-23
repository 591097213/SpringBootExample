package com.ccj.homework.homeworktest2.handlerinterceptoradapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.entity.App;
import com.ccj.homework.homeworktest2.service.handlerinterceptorservice.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * authorization拦截器
 */
@Component
public class AuthorizationInterceptorAdapter extends HandlerInterceptorAdapter {


    @Autowired
    AuthorizationService authorizationTool;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object object) throws Exception {

        // Authorization=appId:appSecret
        String authorization = request.getHeader("Authorization");
        App app = authorizationTool.judgeAppidAndAppSecret(authorization);
        if (app != null) {
            request.setAttribute("app", app);
            return true;
        } else {
            return false;
        }
    }
}
