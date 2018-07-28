package com.ccj.homework.homeworktest2;

import com.ccj.homework.homeworktest2.service.controllerservice.TokenGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YmlTest {

    @Autowired
    TokenGenerator tokenGenerator;

    @Value("${tokenEndTime}")
    private long abc;

    @Value("${refreshTokenEndTime}")
    private long def;

    @Test
    public void timeTest() {

        // System.out.println("************" + tokenGenerator.getTokenEndtime());
        // System.out.println("**********************" + tokenGenerator.getRefreshTokenEndTime());

        System.out.println("***********************" + abc);
        System.out.println("***********************" + def);
    }
}
