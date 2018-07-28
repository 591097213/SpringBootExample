package com.ccj.homework.homeworktest2.handlerinterceptoradapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.dao.ImgCodeRepository;
import com.ccj.homework.homeworktest2.entity.ImgCode;
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
    ImgCodeRepository imgCodeRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object object) throws Exception {

        // 查找uuid参数
        String uuid = request.getParameter("uuid");

        ImgCode imgCode = imgCodeRepository.findByUuid(uuid);
        String code = request.getParameter("imgCode");
        Long time = System.currentTimeMillis();
        // 校验图片验证码
        if (imgCode.getCode().equals(code) && imgCode.getEndTime() > time) {
            return true;
        } else {
            // 校验失败
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
    }

}
