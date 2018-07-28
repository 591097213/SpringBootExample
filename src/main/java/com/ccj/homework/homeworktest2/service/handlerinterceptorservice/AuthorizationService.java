package com.ccj.homework.homeworktest2.service.handlerinterceptorservice;

import com.ccj.homework.homeworktest2.dao.AppRepository;
import com.ccj.homework.homeworktest2.entity.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthorizationService {

    // private Map<String, String> appidAndAppsecret = new HashMap<String, String>();
    @Autowired
    AppRepository appRepository;

    /**
     * 在authorization中获取appid和appsecret
     *
     * [0]元素代表appid
     *
     * [1]元素代表appsecret
     */
    public String[] getAppidAndAppsecretFromAuthorization(String authorization) {
        return authorization.split(":");
    }

    /**
     * 验证appid和appsecret是否有效 返回一个数组，
     *
     * 元素[0]代表校验是否成功， 成功值为"1"，失败值为"0"
     *
     * 若校验成功，元素[1]代表appid
     */
    public App judgeAppidAndAppSecret(String authorization) {


        String[] data = this.getAppidAndAppsecretFromAuthorization(authorization);

        App app = appRepository.findByAppId(data[0]);
        if (app.getAppSecret().equals(data[1])) {
            return app;
        }
        return null;
    }
}
