package com.ccj.homework.homeworktest2.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String account;
    private String pwd;
    private String phoneNum;
    private String token;
    private String imageCOde;
    private String smsCode;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "app_id")
    private App appid;



    /**
     * @return Long return the userId
     */
    public Long getUserId() {
        return id;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.id = userId;
    }

    /**
     * @return String return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return String return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return String return the phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param phoneNum the phoneNum to set
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * @return String return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return String return the imageCOde
     */
    public String getImageCOde() {
        return imageCOde;
    }

    /**
     * @param imageCOde the imageCOde to set
     */
    public void setImageCOde(String imageCOde) {
        this.imageCOde = imageCOde;
    }

    /**
     * @return String return the smsCode
     */
    public String getSmsCode() {
        return smsCode;
    }

    /**
     * @param smsCode the smsCode to set
     */
    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }



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
     * @return App return the appid
     */
    public App getAppid() {
        return appid;
    }

    /**
     * @param appid the appid to set
     */
    public void setAppid(App appid) {
        this.appid = appid;
    }

    // public void setUserAppid(String appid) {
    // this.appid.setAppId(appid);
    // }

}
