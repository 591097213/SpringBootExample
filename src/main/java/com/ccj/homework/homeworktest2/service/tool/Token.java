package com.ccj.homework.homeworktest2.service.tool;

import com.ccj.homework.homeworktest2.dao.AppRepository;
import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.App;
import com.ccj.homework.homeworktest2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class Token {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppRepository appRepository;

    /**
     * 生成并存储Token然后返回该token
     */
    public String generateAndSave(String name, String appid) {

        // 生成token
        String time = Long.toString(System.currentTimeMillis());

        StringBuffer bftoken = new StringBuffer(name);
        // 以冒号分隔用户名和时间戳
        bftoken.append(":");
        bftoken.append(time);
        bftoken.append(":");
        bftoken.append(appid);
        String token = bftoken.toString();

        App app = appRepository.findByAppId(appid);

        // 记录token
        User user = userRepository.findByAccount(name);
        user.setToken(time);
        user.setAppid(app);
        userRepository.save(user);

        // 指定返回json格式
        String format = "{\"token\":\"%s\"}";

        // 设定返回结果
        String result = String.format(format, token);
        // System.out.println("**************************************" + result);
        return result;
    }

    /**
     * 在token中提取用户名
     */
    public String getAccountByToken(String token) {
        String accountAndRawToken[] = token.split(":");
        String account = accountAndRawToken[0];
        return account;
    }
}
