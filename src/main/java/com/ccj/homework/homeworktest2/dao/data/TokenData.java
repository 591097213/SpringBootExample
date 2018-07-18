package com.ccj.homework.homeworktest2.dao.data;

import java.util.*;

/**
 * 存储用户的Token
 */
public class TokenData {

    /**
     * 存放token
     */
    private static List<String> userToken = new ArrayList<String>();

    /**
     * 向类中添加Token
     */
    public static String addUserTokenData(String userTokenData) {
        userToken.add(userTokenData);
        return userTokenData;
    }

    /**
     * 查询Token
     */
    public static boolean findUserToken(String userTokenData) {
        return userToken.contains(userTokenData);
    }

    /**
     * @return the userToken
     */
    public static List<String> getUserToken() {
        return userToken;
    }

    /**
     * @param userToken the userToken to set
     */
    public static void setUserToken(List<String> userToken) {
        TokenData.userToken = userToken;
    }
}
