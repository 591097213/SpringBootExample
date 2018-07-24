package com.ccj.homework.homeworktest2.control.resources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.dao.AppRepository;
import com.ccj.homework.homeworktest2.dao.PhoNumRepository;
import com.ccj.homework.homeworktest2.entity.Account;
import com.ccj.homework.homeworktest2.entity.App;
import com.ccj.homework.homeworktest2.entity.PhoNum;
import com.ccj.homework.homeworktest2.service.controllerservice.GenerateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;;

/**
 * 获取手机验证码模块，包括获取短信验证码和图片验证码
 */
@Api("手机验证码")
@RestController
@RequestMapping("/code")
public class CodeController {

        @Autowired
        GenerateCode generateCode;

        @Autowired
        AppRepository appRepository;

        @Autowired
        PhoNumRepository phoNumRepository;

        /**
         * 获取图片验证码
         */
        @ApiOperation(//
                        value = "发送图片证码", //
                        notes = "根据浏览器给的UUID获取图片验证码"//
        )
        @ApiImplicitParams({//
                        @ApiImplicitParam(//
                                        name = "uuid", //
                                        value = "浏览器生成的UUID", //
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
        @GetMapping(value = "/image")
        public String sendImageCode(//
                        @RequestParam("uuid") String uuid, //
                        HttpServletRequest request) {

                // 查找请求imgCode的app
                App app = (App) request.getAttribute("app");

                // 生成图片验证码
                String format = generateCode.generateAndSaveImageCode(uuid, app);

                return format;
        }

        /**
         * 获取短信验证码
         */
        @ApiOperation(//
                        value = "发送短信验证码", //
                        notes = "向指定手机发送短信验证码"//
        )
        @ApiImplicitParams({ //
                        @ApiImplicitParam(name = "phoNum", //
                                        value = "手机号", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false), //
                        @ApiImplicitParam(//
                                        name = "imgCode", //
                                        value = "图片验证码", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false//
                        ), //
                        @ApiImplicitParam(//
                                        name = "uuid", //
                                        value = "浏览器生成的UUID", //
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
        @PostMapping("/sms")
        public boolean sendSmsCode(//
                        @RequestParam("phoNum") String phoNum, //
                        HttpServletResponse response, //
                        HttpServletRequest request) {

                // 查找请求smsCode的app
                App app = (App) request.getAttribute("app");

                PhoNum pho = phoNumRepository.findByNum(phoNum);
                Account account = pho.getAccount();

                // 生成短信验证码
                String format = generateCode.generateAndSaveSmsCode(account, app);
                // 输出短信验证码并返回true
                System.out.println(format);

                return true;
        }

}
