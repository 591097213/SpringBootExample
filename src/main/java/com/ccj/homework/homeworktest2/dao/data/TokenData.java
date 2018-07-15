package com.ccj.homework.homeworktest2.dao.data;

import java.util.*;


/**
 * 存储用户的Tocken
 */
public class TokenData {

    /**
     * 存放用户名与tocken
     */
    private static List<String> userTocken = new ArrayList<String>();

    /**
     * 向类中添加Tocken
     */
    public static String addUserTockenData(String userTockenData) {
        userTocken.add(userTockenData);
        return userTockenData;
    }

    /**
     * 查询Tocken
     */
    public static boolean findUserTocken(String userTockenData) {
        return userTocken.contains(userTockenData);
    }

    /**
     * @return the userTocken
     */
    public static List<String> getUserTocken() {
        return userTocken;
    }

    /**
     * @param userTocken the userTocken to set
     */
    public static void setUserTocken(List<String> userTocken) {
        TokenData.userTocken = userTocken;
    }
}
