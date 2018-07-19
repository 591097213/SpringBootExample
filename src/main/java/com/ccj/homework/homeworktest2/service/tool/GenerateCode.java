package com.ccj.homework.homeworktest2.service.tool;

import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenerateCode {

    @Autowired
    UserRepository userRepository;

    /**
     * 生成并存储图片验证码
     */
    public String generateAndSaveImageCode(String phoneNumber) {
        // 生成验证码
        int code = (int) (Math.random() * 10000);
        // 补充前导0
        String result = String.format("%04d", code);

        // 储存验证码
        User user = userRepository.findByPhoneNum(phoneNumber);
        user.setImageCOde(result);
        userRepository.save(user);

        // 设定输出格式
        String rawFormat = "{\"imgcode\":\"%s\"}";
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
        System.out.println("---------------------" + phoneNumber);
        User user = userRepository.findByPhoneNum(phoneNumber);
        user.setSmsCode(result);
        userRepository.save(user);

        // 设定输出格式
        String rawFormat = "{\"smscode\":\"%s\"}";
        String format = String.format(rawFormat, result);
        return format;
    }
}
