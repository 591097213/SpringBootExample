package com.ccj.homework.homeworktest2.login;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "登录用户名", dataType = "String",
                    paramType = "query", required = true, allowMultiple = false),
            @ApiImplicitParam(name = "pwd", value = "登录密码", dataType = "String",
                    paramType = "query", required = true, allowMultiple = false)})
    @PostMapping("/login")
    public void verification(@RequestParam("name") String name, @RequestParam("pwd") String pwd,
            HttpServletRequest request, HttpServletResponse response) throws LoginException {

        HttpSession session = request.getSession();

        if (name.equals("root") && pwd.equals("root")) {
            User user = new User();
            user.setName(name);
            session.setAttribute("user", user);
            // return "登录成功!";
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            throw new LoginException("用户名或密码错误");

        }
    }
}
