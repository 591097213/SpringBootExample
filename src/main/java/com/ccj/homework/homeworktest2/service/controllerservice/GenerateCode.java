package com.ccj.homework.homeworktest2.service.controllerservice;

import java.util.Collection;
import com.ccj.homework.homeworktest2.dao.AppRepository;
import com.ccj.homework.homeworktest2.dao.ImgCodeRepository;
import com.ccj.homework.homeworktest2.dao.PhoNumRepository;
import com.ccj.homework.homeworktest2.dao.SmsCodeRepository;
import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.App;
import com.ccj.homework.homeworktest2.entity.ImgCode;
import com.ccj.homework.homeworktest2.entity.PhoNum;
import com.ccj.homework.homeworktest2.entity.SmsCode;
import com.ccj.homework.homeworktest2.entity.User;
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
        System.out.println("******************************generate");
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
    public String generateAndSaveSmsCode(User user, App app, PhoNum phoNum) {
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
        smsCode.setApp(app);
        smsCode.setUser(user);
        smsCodeRepository.save(smsCode);

        // 存储user表
        Collection<SmsCode> userSmsCodes = user.getSmsCodes();
        userSmsCodes.add(smsCode);
        user.setSmsCodes(userSmsCodes);
        userRepository.save(user);

        // 存储app表
        Collection<SmsCode> appSmsCodes = app.getSmsCodes();
        appSmsCodes.add(smsCode);
        app.setSmsCodes(appSmsCodes);
        appRepository.save(app);

        // 存储PhoNum表
        Collection<SmsCode> phoNumSmsCodes = phoNum.getSmsCodes();
        phoNumSmsCodes.add(smsCode);
        phoNum.setSmsCodes(phoNumSmsCodes);
        phoNumRepository.save(phoNum);


        // 设定输出格式
        String rawFormat = "{\"smscode\":\"%s\"}";
        String format = String.format(rawFormat, result);
        return format;
    }
}
