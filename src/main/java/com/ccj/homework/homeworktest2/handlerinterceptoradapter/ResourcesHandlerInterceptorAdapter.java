package com.ccj.homework.homeworktest2.handlerinterceptoradapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.dao.data.TokenData;
import com.ccj.homework.homeworktest2.service.Token;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ResourcesHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object object) throws Exception {
        // System.out.println("***********************************************进入资源拦截器");
        String token = request.getParameter("token");
        System.out.println(token);
        Token toolToken = new Token();
        String account = toolToken.getAccountByToken(token);
        // System.out.println("--------------------------------------------" + account);
        request.setAttribute("account", account);
        if (TokenData.findUserToken(token) == true) {
            return true;
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
    }
}
