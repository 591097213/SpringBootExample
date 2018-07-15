package com.ccj.homework.homeworktest2.control.authorization;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.other.staticdata.AccountAndPwd;
import com.ccj.homework.homeworktest2.service.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 登录接口，包含账号密码登录和手机号登录
 */
@Api("登录接口")
@RestController
@RequestMapping("/login")
public class Login {

        // 读取账户和密码
        @Autowired
        AccountAndPwd accountAndPwd;

        /**
         * 账号密码登录
         */
        @ApiOperation(value = "账号密码登录", notes = "使用账号密码登录的接口")
        @ApiImplicitParams({ //
                        @ApiImplicitParam(//
                                        name = "account", //
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
                        ) })
        @PostMapping("/account-and-pwd")
        public String loginByAccountAndPwd(//
                        @RequestParam("account") String account, //
                        @RequestParam("pwd") String pwd, //
                        HttpServletResponse response) throws LoginException {

                if (pwd.equals(accountAndPwd.getPwdByAccount(account))) {

                        Token tocken = new Token();
                        return tocken.generateAndSave(account);
                } else {

                        // 登录失败
                        response.setStatus(HttpStatus.UNAUTHORIZED.value());
                        throw new LoginException("用户名或密码错误");

                }
        }

        /**
         * 手机号登录
         */
        @ApiOperation(value = "手机号短信验证码登录", notes = "使用手机号和短信验证码登录")
        @ApiImplicitParams({ //
                        @ApiImplicitParam(//
                                        name = "phoNum", //
                                        value = "手机号", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false//
                        ), //
                        @ApiImplicitParam(//
                                        name = "smsCode", //
                                        value = "短信验证码", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false//
                        ) })
        @PostMapping("phone-num")
        public String loginByPhoneNum(//
                        @RequestParam("phoNum") String phoNum//
        ) throws LoginException {

                // TO DO
                // 判断手机号是否合法，不合法则抛出LoginException

                Token token = new Token();
                return token.generateAndSave(phoNum);

        }

}
