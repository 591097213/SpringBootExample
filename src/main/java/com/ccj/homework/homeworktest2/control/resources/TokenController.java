package com.ccj.homework.homeworktest2.control.resources;

import javax.servlet.http.HttpServletRequest;
import com.ccj.homework.homeworktest2.entity.RefreshToken;
import com.ccj.homework.homeworktest2.service.controllerservice.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * TokenController
 */
@Api("Token管理模块")
@RestController
@RequestMapping("/token")
public class TokenController {

        @Autowired
        TokenGenerator tokenGenerator;

        @ApiOperation(//
                        value = "刷新Token", //
                        notes = "根据refreshToken刷新Token"//
        )
        @ApiImplicitParams({//
                        @ApiImplicitParam(//
                                        name = "refreshToken", //
                                        value = "刷新token", //
                                        dataType = "String", //
                                        paramType = "query", //
                                        required = true, //
                                        allowMultiple = false//
                        )})
        @GetMapping
        public String refreshToken(HttpServletRequest request) {

                RefreshToken refreshToken = (RefreshToken) request.getAttribute("refreshToken");

                String format = tokenGenerator.refreshToken(refreshToken);

                return format;

        }

}
