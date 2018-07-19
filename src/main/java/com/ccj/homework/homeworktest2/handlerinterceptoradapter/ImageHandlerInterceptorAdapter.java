package com.ccj.homework.homeworktest2.handlerinterceptoradapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.service.tool.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 图片验证码拦截器
 */
@Component
public class ImageHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    // @Autowired
    // public AccountData accountData;
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object object) throws Exception {

        // 查找phoNum参数
        String phoNum = request.getParameter("phoNum");
        // 若未找到，则查找token参数
        if (phoNum == null) {
            String token = request.getParameter("token");
            Token toolToken = new Token();
            // 由token得出用户名
            String account = toolToken.getAccountByToken(token);
            // 由用户名查找手机号
            String temp = userRepository.findByAccount(account).getPhoneNum();
            phoNum = temp;
        }
        String imgCode = request.getParameter("imgCode");
        // 校验图片验证码
        if (userRepository.findByPhoneNum(phoNum).getImageCOde().equals(imgCode)) {
            return true;
        } else {
            // 校验失败
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
    }

}
