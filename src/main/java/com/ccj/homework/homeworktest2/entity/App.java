package com.ccj.homework.homeworktest2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class App {

    @Id
    @GeneratedValue
    private Long id;

    private String appId;
    private String appsecret;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId the appId to set
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return String return the appsecret
     */
    public String getAppsecret() {
        return appsecret;
    }

    /**
     * @param appsecret the appsecret to set
     */
    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

}
