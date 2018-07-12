package com.ccj.homework.homeworktest2.data;

import java.util.*;

public class UserTockenData {

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

}
