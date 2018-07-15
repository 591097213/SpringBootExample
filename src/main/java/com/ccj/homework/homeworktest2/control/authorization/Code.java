package com.ccj.homework.homeworktest2.control.authorization;

import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.service.GenerateCode;
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
public class Code {

        /**
         * 获取图片验证码
         */
        @ApiOperation(//
                        value = "发送图片证码", //
                        notes = "向指定手机发送图片验证码"//
        )
        @ApiImplicitParam(//
                        name = "phoneNumber", //
                        value = "手机号", //
                        dataType = "String", //
                        paramType = "query", //
                        required = true, //
                        allowMultiple = false//
        )
        @GetMapping(value = "/image")
        public String sendImageCode(@RequestParam("phoneNumber") String phoneNum) {

                GenerateCode generateCode = new GenerateCode();
                String format = generateCode.generateAndSaveImageCode(phoneNum);

                return format;
        }


        /**
         * 获取短信验证码
         */
        @ApiOperation(//
                        value = "发送短信验证码", //
                        notes = "向指定手机发送短信验证码"//
        )
        @ApiImplicitParams({//
                        @ApiImplicitParam(name = "phoneNum", //
                                        value = "手机号", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false), //
                        @ApiImplicitParam(//
                                        name = "imageCode", //
                                        value = "图片验证码", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false//
                        )})
        @PostMapping("/sms")
        public String sendSmsCode(//
                        @RequestParam("phoneNum") String phoneNum, //
                        HttpServletResponse response//
        ) {

                GenerateCode generateCode = new GenerateCode();
                String format = generateCode.generateAndSaveSmsCode(phoneNum);

                return format;
        }



}
