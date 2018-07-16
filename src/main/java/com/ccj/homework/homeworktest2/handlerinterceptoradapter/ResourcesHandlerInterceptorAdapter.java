package com.ccj.homework.homeworktest2.handlerinterceptoradapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.dao.data.TokenData;
import com.ccj.homework.homeworktest2.service.Token;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 资源拦截器
 */
@Component
public class ResourcesHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        // 从参数中提取token
        String token = request.getParameter("token");

        // 从token中提取用户名，供修改密码接口使用
        Token toolToken = new Token();
        String account = toolToken.getAccountByToken(token);
        request.setAttribute("account", account);

        // 验证token是否有效
        if (TokenData.findUserToken(token) == true) {
            return true;
        } else {
            // 校验失败
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
    }
}
