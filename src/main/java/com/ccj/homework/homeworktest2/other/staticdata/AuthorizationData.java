package com.ccj.homework.homeworktest2.other.staticdata;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "authorization")
public class AuthorizationData {

    private Map<String, String> appidAndAppsecret = new HashMap<String, String>();

    /**
     * @return the appidAndAppsecret
     */
    public Map<String, String> getAppidAndAppsecret() {
        return appidAndAppsecret;
    }

    /**
     * @param appidAndAppsecret the appidAndAppsecret to set
     */
    public void setAppidAndAppsecret(Map<String, String> appidAndAppsecret) {
        this.appidAndAppsecret = appidAndAppsecret;
    }

    /**
     * 通过appid查询appsecret
     */
    public String getAppsecretByAppid(String appid) {
        return appidAndAppsecret.get(appid);
    }

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
        if (appidAndAppsecret.get(data[0]).equals(data[1])) {
            result[0] = "1";
            result[1] = data[0];
        }
        return result;
    }
}
