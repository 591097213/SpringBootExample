package com.ccj.homework.homeworktest2.phone;

import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.data.IdentifyingCodeData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Api("手机验证码")
@RestController
public class Phone {


    /**
     * 接收并校验验证码
     */
    @ApiOperation(//
            value = "收验证码", //
            notes = "接收并验证手机验证码"//
    )
    @ApiImplicitParams({//
            @ApiImplicitParam(name = "phoneNumber", //
                    value = "手机号", //
                    dataType = "String", //
                    paramType = "query", //
                    required = true, //
                    allowMultiple = false), //
            @ApiImplicitParam(//
                    name = "identifyingCode", //
                    value = "验证码", //
                    dataType = "String", //
                    paramType = "query", //
                    required = true, //
                    allowMultiple = false//
            )})
    @PostMapping("/phone")
    public void receive(//
            @RequestParam("phoneNumber") String phoneNumber, //
            @RequestParam("identifyingCode") String identifyingCode, //
            HttpServletResponse response//
    ) throws Exception {
        if (IdentifyingCodeData.getIdentifyingCodeByNum(phoneNumber).equals(identifyingCode)) {
            // TO DO
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            throw new Exception("验证失败");
        }
    }


    /**
     * 发送验证码
     */
    @ApiOperation(//
            value = "发验证码", //
            notes = "发送手机验证码"//
    )
    @ApiImplicitParam(//
            name = "phoneNumber", //
            value = "手机号", //
            dataType = "String", //
            paramType = "path", //
            required = true, //
            allowMultiple = false//
    )
    @GetMapping(value = "/phone/{phoneNumber}")
    public String send(@PathVariable("phoneNumber") String phoneNumber) {

        // 生成验证码
        int code = (int) (Math.random() * 10000);
        // 补充前导0
        String result = String.format("%04d", code);

        // 储存验证码
        IdentifyingCodeData.setIdentifyingCode(phoneNumber, result);

        // 设定输出格式
        String rawFormat = "{\"identifyingcode\":\"%s\"}";
        String format = String.format(rawFormat, result);

        return format;
    }
}
