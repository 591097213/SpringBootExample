package com.ccj.homework.homeworktest2;

import java.util.Map;
import com.ccj.homework.homeworktest2.other.staticdata.AccountData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    AccountData accountData;

    @Test
    public void contextLoads() {
        Map<String, String> phoNumAndAccount = accountData.getPhoNumAndAccount();

        System.out.println("************************************");
        System.out.println(phoNumAndAccount.get("18350193122"));
        System.out.println(phoNumAndAccount.get("12345678910"));

        System.out.println("************************************");
        System.out.println(accountData.getAccountByPhoNum("18350193122"));
        System.out.println(accountData.getAccountByPhoNum("12345678910"));

        System.out.println("************************************");
        System.out.println(accountData.getPhoNumByAccount("root"));
    }

    @Test
    public void spilt() {
        String a[] = "a:b;c:d".split(":");
        System.out.println(a[0]);
        for (String b : a) {
            System.out.println(b);
        }
    }

    @Test
    public void accountDataTest() {
        System.out.println(accountData.getPhoNumByAccount("root"));
        System.out.println(accountData.getPhoNumByAccount("admin"));
    }

}
