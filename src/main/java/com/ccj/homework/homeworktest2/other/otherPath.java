package com.ccj.homework.homeworktest2.other;

import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.data.UserTockenData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api("资源路径模块")
@RestController
public class otherPath {

        @ApiOperation(//
                        value = "资源路径", //
                        notes = "提供访问资源路径的示例"//
        )

        @ApiImplicitParam(//
                        name = "tocken", //
                        value = "登录tocken", //
                        dataType = "String", //
                        paramType = "query", //
                        required = true, //
                        allowMultiple = false//
        )
        @PostMapping("/other")
        public String otherpath(//
                        @RequestParam("tocken") String tocken, //
                        HttpServletResponse response//
        ) throws Exception {

                // 用于测试定位
                // System.out.println("**************************************************资源模块");
                // System.out.println(userId);
                // System.out.println(tocken);

                if (UserTockenData.findUserTocken(tocken)) {
                        return "Hello";
                } else {
                        response.setStatus(HttpStatus.UNAUTHORIZED.value());
                        throw new Exception("请登录！");
                }
        }
}
