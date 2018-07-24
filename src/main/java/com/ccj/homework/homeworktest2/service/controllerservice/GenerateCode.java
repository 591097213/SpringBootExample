package com.ccj.homework.homeworktest2.service.controllerservice;

import java.util.Collection;
import com.ccj.homework.homeworktest2.dao.AccountRepository;
import com.ccj.homework.homeworktest2.dao.AppRepository;
import com.ccj.homework.homeworktest2.dao.ImgCodeRepository;
import com.ccj.homework.homeworktest2.dao.PhoNumRepository;
import com.ccj.homework.homeworktest2.dao.SmsCodeRepository;
import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.Account;
import com.ccj.homework.homeworktest2.entity.App;
import com.ccj.homework.homeworktest2.entity.ImgCode;
import com.ccj.homework.homeworktest2.entity.SmsCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenerateCode {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImgCodeRepository imgCodeRepository;

    @Autowired
    AppRepository appRepository;

    @Autowired
    SmsCodeRepository smsCodeRepository;

    @Autowired
    PhoNumRepository phoNumRepository;

    @Autowired
    AccountRepository accountRepository;

    /**
     * 生成并存储图片验证码
     */
    public String generateAndSaveImageCode(String uuid, App app) {
        // 生成验证码
        int code = (int) (Math.random() * 10000);
        // 补充前导0
        String result = String.format("%04d", code);

        // 储存imgcode
        ImgCode imgCode = new ImgCode();
        imgCode.setUuid(uuid);
        imgCode.setCode(result);
        Long time = System.currentTimeMillis();
        Long endTime = time + 3600 * 1000;
        imgCode.setEndTime(endTime);
        imgCode.setApp(app);
        imgCodeRepository.save(imgCode);


        // 存储app
        Collection<ImgCode> imgCodes = app.getImgCodes();
        imgCodes.add(imgCode);
        app.setImgCodes(imgCodes);
        appRepository.save(app);

        // 设定输出格式
        String rawFormat = "{\"imgcode\":\"%s\"}";
        String format = String.format(rawFormat, result);
        return format;
    }

    /**
     * 生成并存储短信验证码
     */
    public String generateAndSaveSmsCode(Account account, App app) {

        // 生成验证码
        int code = (int) (Math.random() * 10000);
        // 补充前导0
        String result = String.format("%04d", code);

        // 储存验证码
        SmsCode smsCode = new SmsCode();
        smsCode.setCode(result);
        Long time = System.currentTimeMillis();
        Long endTime = time + 3600 * 1000;
        smsCode.setEndTime(endTime);
        smsCode.setAccount(account);
        smsCodeRepository.save(smsCode);

        // 存储account表
        Collection<SmsCode> smsCodes = account.getSmsCodes();
        smsCodes.add(smsCode);
        account.setSmsCodes(smsCodes);
        accountRepository.save(account);

        // 设定输出格式
        String rawFormat = "{\"smscode\":\"%s\"}";
        String format = String.format(rawFormat, result);
        return format;
    }
}
