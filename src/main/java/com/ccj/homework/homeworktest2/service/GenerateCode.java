package com.ccj.homework.homeworktest2.service;

import com.ccj.homework.homeworktest2.dao.data.ImgCodeAndPhoNumData;
import com.ccj.homework.homeworktest2.dao.data.SmsCodeAndPhoNumData;

public class GenerateCode {

    /**
     * 生成并存储图片验证码
     */
    public String generateAndSaveImageCode(String phoneNumber) {
        // 生成验证码
        int code = (int) (Math.random() * 10000);
        // 补充前导0
        String result = String.format("%04d", code);

        // 储存验证码
        ImgCodeAndPhoNumData.setIdentifyingCode(phoneNumber, result);

        // 设定输出格式
        String rawFormat = "{\"identifyingcode\":\"%s\"}";
        String format = String.format(rawFormat, result);
        return format;
    }


    /**
     * 生成并存储短信验证码
     */
    public String generateAndSaveSmsCode(String phoneNumber) {
        // 生成验证码
        int code = (int) (Math.random() * 10000);
        // 补充前导0
        String result = String.format("%04d", code);

        // 储存验证码
        SmsCodeAndPhoNumData.setPhoNumAndSmsCode(phoneNumber, result);

        // 设定输出格式
        String rawFormat = "{\"identifyingcode\":\"%s\"}";
        String format = String.format(rawFormat, result);
        return format;
    }
}
