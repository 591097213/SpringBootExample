package com.ccj.homework.homeworktest2.service.handlerinterceptorservice;

import com.ccj.homework.homeworktest2.dao.AccountRepository;
import com.ccj.homework.homeworktest2.dao.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ResourceService
 */
@Component
public class ResourceService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AppRepository appRepository;

    /**
     * 返回{accountid,time,appid}的数组 并查找相应的account和app，以引用类型传递的方式返回
     */
    public String[] getData(String token) {
        String data[] = token.split(":");

        return data;
    }
}
