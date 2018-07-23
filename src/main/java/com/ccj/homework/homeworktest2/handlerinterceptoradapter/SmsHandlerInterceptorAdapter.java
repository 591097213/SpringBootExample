package com.ccj.homework.homeworktest2.handlerinterceptoradapter;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.dao.PhoNumRepository;
import com.ccj.homework.homeworktest2.dao.SmsCodeRepository;
import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.PhoNum;
import com.ccj.homework.homeworktest2.entity.SmsCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class SmsHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PhoNumRepository phoNumRepository;

    @Autowired
    SmsCodeRepository smsCodeRepository;

    /**
     * 短信验证码拦截器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object object) throws Exception {

        // 从请求中提取phoNum和smsCode参数
        String phoNum = request.getParameter("phoNum");
        String smsCode = request.getParameter("smsCode");

        PhoNum pho = phoNumRepository.findByNum(phoNum);


        SmsCode judge = smsCodeRepository.findByPhoNumAndCode(pho, smsCode);

        // 校验参数
        if (judge != null) {
            return true;
        } else {

            // 校验失败
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            // throw new Exception("用户名或密码错误");
            return false;
        }

    }
}
