package com.ccj.homework.homeworktest2.service.controllerservice;

import java.util.Collection;
import com.ccj.homework.homeworktest2.dao.AccountRepository;
import com.ccj.homework.homeworktest2.dao.AppRepository;
import com.ccj.homework.homeworktest2.dao.RefreshTokenRepository;
import com.ccj.homework.homeworktest2.dao.TokenRepository;
import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.Account;
import com.ccj.homework.homeworktest2.entity.App;
import com.ccj.homework.homeworktest2.entity.RefreshToken;
import com.ccj.homework.homeworktest2.entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Data;


/**
*
*/
@Component
@Data
public class TokenGenerator {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppRepository appRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Value("${tokenEndTime}")
    private long tokenEndtime;

    @Value("${refreshTokenEndTime}")
    private long refreshTokenEndTime;

    /**
     * 根据account和app生成token
     */
    public String generateAndSave(Account account, App app) {


        // 生成token所需要的字段
        Long time = System.currentTimeMillis();

        Token token = this.getToken(account, app, time);
        RefreshToken refreshToken = this.getRefreshtoken(account, app, time);

        this.record(token, refreshToken, account);

        return format(token, refreshToken, account, app);
    }

    public void record(Token token, RefreshToken refreshToken, Account account) {
        // 数据表的处理

        // 记录account
        Collection<Token> accountTokens = account.getTokens();
        accountTokens.add(token);
        account.setTokens(accountTokens);
        accountRepository.save(account);

        token.setRefreshToken(refreshToken);
        tokenRepository.save(token);

        refreshToken.setToken(token);
        refreshTokenRepository.save(refreshToken);
    }

    public String format(Token token, RefreshToken refreshToken, Account account, App app) {

        String tokenCode = token.getCode();
        String refreshTokenCode = refreshToken.getCode();

        // 创建返回给用户的字符串
        StringBuffer temp1 = new StringBuffer(account.getId().toString());
        // 以冒号分隔用户名和时间戳
        temp1.append(":");
        temp1.append(tokenCode);
        temp1.append(":");
        temp1.append(app.getAppId());
        String returnTokenCode = temp1.toString();

        StringBuffer temp2 = new StringBuffer(account.getId().toString());
        // 以冒号分隔用户名和时间戳
        temp2.append(":");
        temp2.append(refreshTokenCode);
        temp2.append(":");
        temp2.append(app.getAppId());
        String returnRefreshTokenCode = temp2.toString();

        // 指定返回json格式
        String format = "{\"token\":\"%s\",\"refreshToken\":\"%s\"}";

        // 设定返回结果
        String result = String.format(format, returnTokenCode, returnRefreshTokenCode);
        return result;
    }

    public Token getToken(Account account, App app, long time) {

        String currentTime = Long.toString(time);
        Long endTime = time + this.tokenEndtime;

        // 记录token
        Token token = new Token();
        token.setCode(currentTime);
        token.setEndTime(endTime);
        token.setAccount(account);
        // token.setApp(app);
        tokenRepository.save(token);

        return token;
    }

    public RefreshToken getRefreshtoken(Account account, App app, long time) {

        // 前缀
        int prefixNum = (int) (Math.random() * 10000);
        // 补充前导0
        String prefix = String.format("%04d", prefixNum);

        String currentTime = Long.toString(time);
        Long refreshEndTime = time + this.refreshTokenEndTime;

        // 记录refreshToken
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setCode(prefix + currentTime);
        refreshToken.setEndTime(refreshEndTime);
        refreshTokenRepository.save(refreshToken);

        return refreshToken;
    }

    public String refreshToken(RefreshToken refreshToken) {

        long time = System.currentTimeMillis();

        Token token = refreshToken.getToken();
        Account account = token.getAccount();
        App app = token.getApp();
        // token没有过期
        if (token.getEndTime() < time) {

            refreshToken.setEndTime(time + this.refreshTokenEndTime);

            return format(token, refreshToken, account, app);

            // token过期了
        } else {
            Token newToken = this.getToken(account, app, time);
            RefreshToken newRefreshToken = this.getRefreshtoken(account, app, time);

            this.record(token, refreshToken, account);
            return this.format(newToken, newRefreshToken, account, app);

        }

    }
}
