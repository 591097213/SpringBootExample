package com.ccj.homework.homeworktest2.handlerinterceptoradapter;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.ccj.homework.homeworktest2.dao.data.SmsCodeAndPhoNumData;

public class SmsHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    // @Override
    // public void afterCompletion(HttpServletRequest request, HttpServletResponse
    // response, Object object,
    // Exception exception) throws Exception {
    // // 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    // System.out.println("3. 整个请求结束之后被调用......CustomInterceptor1......");
    // }

    // @Override
    // public void postHandle(HttpServletRequest request, HttpServletResponse
    // response, Object object, ModelAndView view)
    // throws Exception {
    // // 请求处理之后进行调用，但是在视图被渲染之前
    // System.out.println("2. 请求处理之后进行调用，但是在视图被渲染之前......CustomInterceptor1......");
    // }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

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
