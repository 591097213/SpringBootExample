package com.ccj.homework.homeworktest2.data;

import java.util.HashMap;
import java.util.Map;

public class IdentifyingCodeData {

    private static Map<String, String> identifyingCode = new HashMap<>();

    /**
     * 获取验证码
     */
    public static String getIdentifyingCodeByNum(String num) {
        return identifyingCode.get(num);
    }

    public static void setIdentifyingCode(String num, String code) {
        identifyingCode.put(num, code);
    }



}
