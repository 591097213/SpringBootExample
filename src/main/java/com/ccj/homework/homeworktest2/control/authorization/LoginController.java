package com.ccj.homework.homeworktest2.control.authorization;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.dao.AccountRepository;
import com.ccj.homework.homeworktest2.dao.AppRepository;
import com.ccj.homework.homeworktest2.dao.PhoNumRepository;
import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.Account;
import com.ccj.homework.homeworktest2.entity.App;
import com.ccj.homework.homeworktest2.entity.PhoNum;
import com.ccj.homework.homeworktest2.service.controllerservice.TokenGenerator;
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
@RequestMapping("/authorization")
public class LoginController {

        // 注入
        @Autowired
        AccountRepository accountRepository;

        @Autowired
        TokenGenerator tokenGenerator;

        @Autowired
        AppRepository appRepository;

        @Autowired
        UserRepository userRepository;

        @Autowired
        PhoNumRepository phoNumRepository;

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
                        ), //
                        @ApiImplicitParam(//
                                        name = "Authorization", //
                                        value = "appid:appsecret", //
                                        dataType = "String", //
                                        paramType = "header", //
                                        required = true, //
                                        allowMultiple = false//
                        )})
        @PostMapping("/accountAndPwd")
        public String loginByAccountAndPwd(//
                        @RequestParam("account") long accountId, //
                        @RequestParam("pwd") String pwd, //
                        HttpServletRequest request, //
                        HttpServletResponse response//
        ) throws LoginException {

                Account account = accountRepository.findById(accountId).get();

                // 验证密码是否正确
                if (pwd.equals(account.getPwd())) {

                        // 提取app
                        App app = (App) request.getAttribute("app");

                        // 生成并保存token
                        return tokenGenerator.generateAndSave(account, app);
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
                        ), //
                        @ApiImplicitParam(//
                                        name = "Authorization", //
                                        value = "appid:appsecret", //
                                        dataType = "String", //
                                        paramType = "header", //
                                        required = true, //
                                        allowMultiple = false//
                        )})
        @PostMapping("phoneNum")
        public String loginByPhoneNum(//
                        @RequestParam("phoNum") String phoNum, //
                        HttpServletRequest request//
        ) throws LoginException {

                // 提取app
                App app = (App) request.getAttribute("app");

                // 获取手机号对象
                PhoNum pho = phoNumRepository.findByNum(phoNum);

                // 根据手机号对象获取账户
                Account account = accountRepository.findByPhoNum(pho);
                // 根据用户名生成token
                return tokenGenerator.generateAndSave(account, app);

        }

}
