package com.ccj.homework.homeworktest2.service;

import java.util.UUID;
import com.ccj.homework.homeworktest2.dao.data.TokenData;

/**
 *
 */
public class Token {

    /**
     * 生成并存储Tocken然后返回该tocken
     */
    public String generateAndSave(String name) {

        // 生成tocken
        StringBuffer bftocken = new StringBuffer(name);
        bftocken.append(UUID.randomUUID().toString().replace("-", ""));
        String tocken = bftocken.toString();

        // 记录tocken
        TokenData.addUserTockenData(tocken);

        // 指定返回json格式
        String format = "{\"tocken\":\"%s\"}";

        // 设定返回结果
        String result = String.format(format, tocken);
        return result;
    }
}
