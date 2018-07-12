package com.ccj.homework.homeworktest2.login;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.data.UserTockenData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("登录系统")
@RestController
public class LoginController {

    @ApiOperation(value = "登录", notes = "提供登录的接口")
    @ApiImplicitParams({//
            @ApiImplicitParam(//
                    name = "name", //
                    value = "登录用户名", //
                    dataType = "String", //
                    paramType = "query", //
                    required = true, //
                    allowMultiple = false//
            ), //
            @ApiImplicitParam(//
                    name = "pwd", //
                    value = "登录密码", //
                    dataType = "String", //
                    paramType = "query", //
                    required = true, //
                    allowMultiple = false//
            )})
    @PostMapping("/login")
    public String verification(//
            @RequestParam("name") String name, //
            @RequestParam("pwd") String pwd, //
            HttpServletRequest request, //
            HttpServletResponse response//
    ) throws LoginException {

        // 装入用户名密码
        Map<String, String> userNameAndPwd = new HashMap<String, String>();
        userNameAndPwd.put("root", "root");

        if (pwd.equals(userNameAndPwd.get(name))) {

            // 生成tocken
            StringBuffer bftocken = new StringBuffer(name);
            bftocken.append(UUID.randomUUID().toString().replace("-", ""));
            String tocken = bftocken.toString();

            // 记录tocken
            UserTockenData.addUserTockenData(tocken);

            // 指定返回json格式
            String format = "{\"tocken\":\"%s\"}";

            // 设定返回结果
            String result = String.format(format, tocken);

            return result;

        } else {

            // 登录失败
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            throw new LoginException("用户名或密码错误");

        }
    }
}
