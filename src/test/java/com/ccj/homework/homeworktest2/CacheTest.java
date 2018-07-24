package com.ccj.homework.homeworktest2;

import com.ccj.homework.homeworktest2.dao.ImgCodeRepository;
import com.ccj.homework.homeworktest2.entity.ImgCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {

    @Autowired
    ImgCodeRepository imgCodeRepository;

    @Test
    public void imgCodeTest() {

        ImgCode imgCode = new ImgCode();
        imgCode.setUuid("999999");
        imgCode.setCode("123456");
        imgCodeRepository.save(imgCode);

        System.out
                .println("**************first:" + imgCodeRepository.findByUuid("999999").getCode());

        System.out.println(
                "**************second:" + imgCodeRepository.findByUuid("999999").getCode());


    }
}
