package com.ccj.homework.homeworktest2.handlerinterceptoradapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.other.staticdata.AuthorizationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * authorization拦截器
 */
@Component
public class AuthorizationInterceptorAdapter extends HandlerInterceptorAdapter {


    @Autowired
    AuthorizationData authorizationData;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object object) throws Exception {

        String authorization = request.getHeader("Authorization");
        String[] result = authorizationData.judgeAppidAndAppSecret(authorization);
        if (result[0].equals("1")) {
            request.setAttribute("appid", result[1]);
            return true;
        } else {
            return false;
        }
    }
}
