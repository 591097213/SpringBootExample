package com.ccj.homework.homeworktest2.handlerinterceptoradapter;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.dao.data.ImgCodeAndPhoNumData;
import com.ccj.homework.homeworktest2.other.staticdata.AccountData;
import com.ccj.homework.homeworktest2.service.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class ImageHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    @Autowired
    public AccountData accountData;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object object) throws Exception {

        String phoNum = request.getParameter("phoNum");
        if (phoNum == null) {
            System.out.println("进入if语句");
            String token = request.getParameter("token");
            Token toolToken = new Token();
            String account = toolToken.getAccountByToken(token);
            String temp = accountData.getPhoNumByAccount(account);
            phoNum = temp;
        }
        String imgCode = request.getParameter("imgCode");

        if (ImgCodeAndPhoNumData.getIdentifyingCodeByNum(phoNum).equals(imgCode)) {
            return true;
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
    }

}
