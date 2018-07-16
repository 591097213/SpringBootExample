package com.ccj.homework.homeworktest2.service;

import com.ccj.homework.homeworktest2.dao.data.TokenData;

/**
 *
 */
public class Token {

    /**
     * 生成并存储Token然后返回该token
     */
    public String generateAndSave(String name) {

        // 生成token
        StringBuffer bftoken = new StringBuffer(name);
        // 以冒号分隔用户名和时间戳
        bftoken.append(":");
        bftoken.append(System.currentTimeMillis());
        String token = bftoken.toString();

        // 记录token
        TokenData.addUserTokenData(token);

        // 指定返回json格式
        String format = "{\"token\":\"%s\"}";

        // 设定返回结果
        String result = String.format(format, token);
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
