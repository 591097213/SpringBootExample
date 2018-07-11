package com.ccj.homework.homeworktest2.other;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("资源路径模块")
@RestController
public class otherPath {

    @ApiOperation(value = "资源路径", notes = "提供访问资源路径的示例")
    @ApiImplicitParam(name = "tocken", value = "登录tocken", dataType = "String", paramType = "query",
            required = true, allowMultiple = false)
    @PostMapping("/other")
    public String otherpath(@RequestParam("tocken") String tocken, HttpServletResponse response)
            throws Exception {
        if (tocken.equals("123456")) {
            return "Hello";
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            throw new Exception("请登录！");
        }
    }
}
