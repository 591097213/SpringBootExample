package com.ccj.homework.homeworktest2.dao.data;



import java.util.HashMap;
import java.util.Map;

/**
 * 存储手机号与短信验证码数据
 */
public class SmsCodeAndPhoNumData {

    private static Map<String, String> smsCodeAndPhoNumData = new HashMap<>();

    /**
     * @return the smsCodeAndPhoNumData
     */
    public static Map<String, String> getSmsCodeAndPhoNumData() {
        return smsCodeAndPhoNumData;
    }

    /**
     * @param smsCodeAndPhoNumData the smsCodeAndPhoNumData to set
     */
    public static void setSmsCodeAndPhoNumData(Map<String, String> smsCodeAndPhoNumData) {
        SmsCodeAndPhoNumData.smsCodeAndPhoNumData = smsCodeAndPhoNumData;
    }

    /**
     * 获取验证码
     */
    public static String getSmsCodeByPhoNum(String phoNum) {
        return smsCodeAndPhoNumData.get(phoNum);
    }

    public static void setPhoNumAndSmsCode(String phoNum, String smsCode) {
        smsCodeAndPhoNumData.put(phoNum, smsCode);
    }

}
