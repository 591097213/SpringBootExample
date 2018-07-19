package com.ccj.homework.homeworktest2.control.resources;

import javax.servlet.http.HttpServletRequest;
import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("密码管理模块")
@RestController
@RequestMapping("/pwd")
public class PwdController {

        // @Autowired
        // AccountData accountdata;
        @Autowired
        UserRepository userRepository;

        @ApiOperation(value = "修改密码", notes = "修改密码")
        @ApiImplicitParams({ //
                        @ApiImplicitParam(//
                                        name = "imgCode", //
                                        value = "图片验证码", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false//
                        ), //
                        @ApiImplicitParam(//
                                        name = "token", //
                                        value = "token", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false//
                        ), //
                        @ApiImplicitParam(//
                                        name = "newPwd", //
                                        value = "新密码", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false//
                        ), //
                        @ApiImplicitParam(//
                                        name = "oldPwd", //
                                        value = "旧密码", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false//
                        )//
        })
        @PostMapping("/alter")
        public boolean resetPwd(@RequestParam("newPwd") String newPwd,
                        @RequestParam("oldPwd") String oldPwd, HttpServletRequest request) {
                // 从request中取出ResourcesHandlerInterceptorAdapter放入的用户名
                String account = (String) request.getAttribute("account");
                // 验证旧密码是否正确
                if (userRepository.findByAccount(account).getPwd().equals(oldPwd)) {
                        // 修改密码
                        User user = userRepository.findByAccount(account);
                        user.setPwd(newPwd);
                        userRepository.save(user);
                        return true;
                } else {
                        return false;
                }
        }
}
