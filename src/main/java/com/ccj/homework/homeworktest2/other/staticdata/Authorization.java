package com.ccj.homework.homeworktest2.other.staticdata;

import com.ccj.homework.homeworktest2.dao.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Authorization {

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
    public String[] judgeAppidAndAppSecret(String authorization) {

        String[] result = {"0", null};
        String[] data = this.getAppidAndAppsecretFromAuthorization(authorization);
        if (appRepository.findByAppId(data[0]).getAppsecret().equals(data[1])) {
            result[0] = "1";
            result[1] = data[0];
        }
        return result;
    }
}
