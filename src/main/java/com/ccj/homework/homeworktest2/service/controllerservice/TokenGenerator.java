package com.ccj.homework.homeworktest2.service.controllerservice;

import java.util.Collection;
import com.ccj.homework.homeworktest2.dao.AccountRepository;
import com.ccj.homework.homeworktest2.dao.AppRepository;
import com.ccj.homework.homeworktest2.dao.TokenRepository;
import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.Account;
import com.ccj.homework.homeworktest2.entity.App;
import com.ccj.homework.homeworktest2.entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
*
*/
@Component
public class TokenGenerator {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppRepository appRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TokenRepository tokenRepository;

    /**
     * 根据account和app生成token
     */
    public String generateAndSave(Account account, App app) {

        // 生成token所需要的字段
        Long time = System.currentTimeMillis();
        String currentTime = Long.toString(time);
        Long endTime = time + 3600 * 1000;


        // 创建返回给用户的字符串
        StringBuffer bftoken = new StringBuffer(account.getId().toString());
        // 以冒号分隔用户名和时间戳
        bftoken.append(":");
        bftoken.append(currentTime);
        bftoken.append(":");
        bftoken.append(app.getAppId());
        String code = bftoken.toString();


        // 数据表的处理

        // 记录token
        Token token = new Token();
        token.setCode(currentTime);
        token.setEndTime(endTime);
        token.setAccount(account);
        tokenRepository.save(token);

        // 记录account
        Collection<Token> accountTokens = account.getTokens();
        accountTokens.add(token);
        account.setTokens(accountTokens);
        accountRepository.save(account);

        // 指定返回json格式
        String format = "{\"token\":\"%s\"}";

        // 设定返回结果
        String result = String.format(format, code);
        return result;
    }

}
