package com.ccj.homework.homeworktest2;

import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.User;
import com.ccj.homework.homeworktest2.service.tool.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {

        User user;
        // findById
        user = userRepository.findById(Long.valueOf(1)).orElse(null);
        // findByPhoneNum
        user = userRepository.findByPhoneNum("18350193122");

    }

    @Test
    public void randomUtilsTest() {
        RandomUtils randomUtils;

        // System.out.println(randomUtils.get);
    }

}
