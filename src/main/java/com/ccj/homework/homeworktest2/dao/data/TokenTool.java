package com.ccj.homework.homeworktest2.dao.data;

import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.App;
import com.ccj.homework.homeworktest2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 存储用户的Token
 */
@Component
public class TokenTool {

    @Autowired
    UserRepository userRepository;

    /**
     * 存放token
     */
    // private static List<String> userToken = new ArrayList<String>();

    /**
     * 向类中添加Token
     */
    public void addUserTokenData(String userTokenData) {
        String[] tokendata = userTokenData.split(":");
        User user = userRepository.findByAccount(tokendata[0]);
        user.setToken(tokendata[1]);

        App app = new App();
        app.setAppId(tokendata[2]);

        user.setAppid(app);
        userRepository.save(user);
    }

    /**
     * 查询Token
     */
    public boolean findUserToken(String userTokenData) {
        String[] tokendata = userTokenData.split(":");
        User user = userRepository.findByAccount(tokendata[0]);
        if (user.getToken().equals(tokendata[1])) {
            return true;
        } else {
            return false;
        }
    }

}
