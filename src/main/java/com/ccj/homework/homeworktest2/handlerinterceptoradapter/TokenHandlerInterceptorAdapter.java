package com.ccj.homework.homeworktest2.handlerinterceptoradapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.dao.RefreshTokenRepository;
import com.ccj.homework.homeworktest2.entity.RefreshToken;
import com.ccj.homework.homeworktest2.service.handlerinterceptorservice.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TokenHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    @Autowired
    ResourceService resourceService;

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    /**
     * Token管理模块拦截器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object object) throws Exception {

        String refreshTokenString = request.getParameter("refreshToken");
        String data[] = resourceService.getData(refreshTokenString);
        RefreshToken refreshToken = refreshTokenRepository.findByCode(data[1]);
        if (refreshToken != null) {
            long time = System.currentTimeMillis();
            if (refreshToken.getEndTime() < time) {
                request.setAttribute("refreshToken", refreshToken);
                return true;
            } else {
                response.setStatus(HttpStatus.FORBIDDEN.value());
                return false;
            }
        } else {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return false;
        }

    }
}
