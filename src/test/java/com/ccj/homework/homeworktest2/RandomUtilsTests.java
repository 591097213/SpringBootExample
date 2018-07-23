package com.ccj.homework.homeworktest2;

import com.ccj.homework.homeworktest2.service.initservice.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomUtilsTests {

    @Test
    public void getRoadTest() {

        // System.out.println("hello");
        System.out.println("***************************" + RandomUtils.getRoad());
    }
}
