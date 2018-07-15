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

    Map<String, String> accountAndPwd = new HashMap<String, String>();
    Map<String, String> phoNumAndAccount = new HashMap<String, String>();


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
}
