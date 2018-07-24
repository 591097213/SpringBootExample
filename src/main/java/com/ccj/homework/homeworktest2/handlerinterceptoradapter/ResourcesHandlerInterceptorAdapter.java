package com.ccj.homework.homeworktest2.handlerinterceptoradapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.dao.AccountRepository;
import com.ccj.homework.homeworktest2.dao.AppRepository;
import com.ccj.homework.homeworktest2.dao.TokenRepository;
import com.ccj.homework.homeworktest2.entity.Account;
import com.ccj.homework.homeworktest2.entity.Token;
import com.ccj.homework.homeworktest2.service.handlerinterceptorservice.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 资源拦截器
 */
@Component
public class ResourcesHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    @Autowired
    ResourceService resourceService;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AppRepository appRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object object) throws Exception {
        System.out.println("**********************************************into");

        // 从参数中提取token
        String token = request.getParameter("token");

        String[] data = resourceService.getData(token);
        Account account = accountRepository.findById(Long.valueOf(data[0])).get();
        // App app = appRepository.findByAppId(data[2]);


        // 从token中提取用户名，供修改密码接口使用
        request.setAttribute("account", account);

        Token judge = tokenRepository.findByAccountAndCode(account, data[1]);
        // 验证token是否有效
        if (judge != null) {
            return true;
        } else {
            // 校验失败
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
    }
}
