package com.ccj.homework.homeworktest2.other;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api("测试")
@RestController
public class Test {

    @ApiOperation(value = "测试登录", notes = "供测试登录")
    @ApiImplicitParam(name = "tocken", value = "登录tocken", dataType = "String", paramType = "query",
            required = true, allowMultiple = false)
    @PostMapping("/test")
    public String say(@RequestParam("tocken") String tocken) {
        return "HELLO";
    }
}
