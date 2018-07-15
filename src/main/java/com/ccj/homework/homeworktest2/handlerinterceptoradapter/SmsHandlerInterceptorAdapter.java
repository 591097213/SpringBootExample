package com.ccj.homework.homeworktest2.handlerinterceptoradapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.dao.data.SmsCodeAndPhoNumData;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SmsHandlerInterceptorAdapter extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object object) throws Exception {
        // System.out.println("********************************进入短信验证码拦截器");
        String phoNum = request.getParameter("phoNum");
        String smsCode = request.getParameter("smsCode");

        if (SmsCodeAndPhoNumData.getSmsCodeByPhoNum(phoNum).equals(smsCode)) {
            return true;
        } else {

            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            // throw new Exception("用户名或密码错误");
            return false;
        }

    }
}
