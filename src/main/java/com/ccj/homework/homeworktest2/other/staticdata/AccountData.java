package com.ccj.homework.homeworktest2.other.staticdata;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 获取YML文件中的用户名和密码
 */
@Component
@ConfigurationProperties(prefix = "login")
public class AccountData {

    private Map<String, String> accountAndPwd = new HashMap<String, String>();
    private Map<String, String> phoNumAndAccount = new HashMap<String, String>();
    private Map<String, String> accountAndPhoNum = new HashMap<String, String>();


    /**
     * @param accountAndPwd the accountAndPwd to set
     */
    public void setAccountAndPwd(Map<String, String> accountAndPwd) {
        this.accountAndPwd = accountAndPwd;
    }

    /**
     * @return the accountAndPwd
     */
    public Map<String, String> getAccountAndPwd() {
        return accountAndPwd;
    }

    /**
     * @return the phoNumAndPwd
     */
    public Map<String, String> getPhoNumAndAccount() {
        return phoNumAndAccount;
    }

    /**
     * @param phoNumAndAccount the phoNumAndPwd to set
     */
    public void setPhoNumAndPwd(Map<String, String> phoNumAndAccount) {
        this.phoNumAndAccount = phoNumAndAccount;
    }

    /**
     * @return the accountAndPhoNum
     */
    public Map<String, String> getAccountAndPhoNum() {
        return accountAndPhoNum;
    }

    /**
     * @param accountAndPhoNum the accountAndPhoNum to set
     */
    public void setAccountAndPhoNum(Map<String, String> accountAndPhoNum) {
        this.accountAndPhoNum = accountAndPhoNum;
    }

    /**
     * 根据手机号获取用户名
     */
    public String getAccountByPhoNum(String phoNum) {
        return phoNumAndAccount.get(phoNum);
    }

    /**
     * 根据用户名获取密码
     */
    public String getPwdByAccount(String account) {
        return accountAndPwd.get(account);
    }


    /**
     * 修改密码
     */
    public boolean resetPwdByAccount(String account, String pwd) {
        accountAndPwd.put(account, pwd);
        return true;
    }

    /**
     * 根据用户名获取手机号
     */
    public String getPhoNumByAccount(String account) {
        return this.accountAndPhoNum.get(account);
    }
}
