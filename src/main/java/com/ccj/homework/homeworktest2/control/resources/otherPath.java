package com.ccj.homework.homeworktest2.control.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@Api("资源路径模块")
@RestController
public class otherPath {

        // @ApiOperation(//
        // value = "资源路径", //
        // notes = "提供访问资源路径的示例"//
        // )

        // @ApiImplicitParam(//
        // name = "tocken", //
        // value = "登录tocken", //
        // dataType = "String", //
        // paramType = "query", //
        // required = true, //
        // allowMultiple = false//
        // )
        @GetMapping("/other")
        public String otherpath() {

                return "hello";
        }
}
