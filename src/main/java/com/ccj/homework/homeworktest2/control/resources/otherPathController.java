package com.ccj.homework.homeworktest2.control.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("资源路径模块")
@RestController
public class OtherPathController {

        @ApiOperation(//
                        value = "资源路径", //
                        notes = "提供访问资源路径的示例"//
        )
        @ApiImplicitParams({//
                        @ApiImplicitParam(//
                                        name = "token", //
                                        value = "登录token", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false//
                        )})
        @GetMapping("/other")
        public String otherpath() {

                return "hello";
        }
}
