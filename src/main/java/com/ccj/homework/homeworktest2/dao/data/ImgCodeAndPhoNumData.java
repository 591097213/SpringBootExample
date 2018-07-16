package com.ccj.homework.homeworktest2.dao.data;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储手机号与图片验证码数据
 */
public class ImgCodeAndPhoNumData {

    private static Map<String, String> imgCodeAndPhoNum = new HashMap<>();

    /**
     * @return the imgCodeAndPhoNum
     */
    public static Map<String, String> getImgCodeAndPhoNum() {
        return imgCodeAndPhoNum;
    }

    /**
     * @param imgCodeAndPhoNum the imgCodeAndPhoNum to set
     */
    public static void setImgCodeAndPhoNum(Map<String, String> imgCodeAndPhoNum) {
        ImgCodeAndPhoNumData.imgCodeAndPhoNum = imgCodeAndPhoNum;
    }

    /**
     * 根据手机号获取图片验证码
     */
    public static String getIdentifyingCodeByNum(String num) {
        return imgCodeAndPhoNum.get(num);
    }

    /**
     * 存入手机号和相应的图片验证码
     */
    public static void setIdentifyingCode(String num, String code) {
        imgCodeAndPhoNum.put(num, code);
    }

}
